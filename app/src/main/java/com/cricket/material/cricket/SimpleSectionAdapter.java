package com.cricket.material.cricket;

import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.cricket.material.cricket.Upcoming.Match;
import com.cricket.material.cricket.Upcoming.Series;
import com.cricket.material.cricket.Upcoming.Upcoming;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smitald on 7/16/2015.
 */
public abstract class SimpleSectionAdapter<T> extends BaseAdapter implements AdapterView.OnItemClickListener, ValueEventListener {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private static final String TAG = "SimpleSectionAdapter";

    private LayoutInflater mLayoutInflater;
    private int mHeaderResId;
    private int mItemResId;

    List<SectionItem<T>> mSectionItems;

    private SparseArray<SectionItem<T>> mKeyedSections;

    private Firebase mRef;


    // Its really important to note that there is this abstract method

    public abstract void onSectionItemClick(T item);


    public SimpleSectionAdapter(ListView parent, int headerResId, int itemResId) {
        mLayoutInflater = LayoutInflater.from(parent.getContext());
        mHeaderResId = headerResId;
        mItemResId = itemResId;
        mSectionItems = new ArrayList<>();
        mKeyedSections = new SparseArray<>();
        Firebase.setAndroidContext(parent.getContext());
        mRef = new Firebase("https://coolapi.firebaseio.com/upcoming");
        mRef.addValueEventListener(this);
    }

    public void AddSections(String title, T[] items) {
        SectionItem<T> sectionItem = new SectionItem<>(title, items);
        int currentIndex = mSectionItems.indexOf(sectionItem);

        if (currentIndex >= 0) {
            mSectionItems.remove(sectionItem);
            mSectionItems.add(currentIndex, sectionItem);
        } else {
            mSectionItems.add(sectionItem);
        }

        reorderSections();

        notifyDataSetChanged();
    }

    private void reorderSections() {
        mKeyedSections.clear();
        int startPosition = 0;

        for (SectionItem<T> item : mSectionItems) {
            mKeyedSections.put(startPosition, item);
            startPosition += item.getCount();
        }
    }

    @Override
    public int getCount() {
        int count = 0;
        for (SectionItem<T> item : mSectionItems) {
            count += item.getCount();
        }
        return count;
    }

    @Override
    public Object getItem(int position) {
        return findSectionItemAtPosition(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        switch (getItemViewType(position)) {
            case TYPE_HEADER:
                return getHeaderView(position, convertView, parent);
            case TYPE_ITEM:
                return getItemView(position, convertView, parent);
            default:
                Log.e(TAG, "getView : ");
                return convertView;
        }
    }

    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(mHeaderResId, parent, false);
        }
        SectionItem<T> sectionItem = mKeyedSections.get(position);
        TextView textView = (TextView) convertView.findViewById(android.R.id.text1);
        textView.setText(sectionItem.getmTitle());
        return convertView;
    }

    public View getItemView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(mItemResId, parent, false);
        }
        T item = findSectionItemAtPosition(position);
        Match match = (Match)item;

        TextView textViewMeta = (TextView) convertView.findViewById(R.id.upcoming_match_meta);
        TextView textViewTeam = (TextView) convertView.findViewById(R.id.upcoming_match_team);
        TextView textViewVenue = (TextView) convertView.findViewById(R.id.upcoming_match_venue);

        textViewMeta.setText(match.getDate());
        String str = match.getTeam1() + "Vs" + " " + match.getTeam2();
        textViewTeam.setText(str);
        textViewVenue.setText(match.getVenue());
        return convertView;
    }

    private T findSectionItemAtPosition(int position) {
        int firstIndex, lastIndex;

        for (int i = 0; i <= mKeyedSections.size(); i++) {
            firstIndex = mKeyedSections.keyAt(i);
            lastIndex = firstIndex + mKeyedSections.valueAt(i).getCount();

            if (position >= firstIndex && position < lastIndex) {
                int sectionPosition = position - firstIndex - 1;
                return mKeyedSections.valueAt(i).getItem(sectionPosition);
            }
        }
        return null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        T item = findSectionItemAtPosition(position);
        if (item != null) {
            onSectionItemClick(item);
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeaderPosition(position)) {
            return TYPE_HEADER;
        } else {
            return TYPE_ITEM;
        }
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return !isHeaderPosition(position);
    }

    private boolean isHeaderPosition(int position) {
        for (int i = 0; i <= mKeyedSections.size(); i++) {
            if (position == mKeyedSections.keyAt(i)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Log.d(TAG, "onDataChange ");
        Upcoming upcoming = dataSnapshot.getValue(Upcoming.class);
        List<Series> items = upcoming.getSeries();
        for (Series item : items) {
             AddSections(item.getSeriesName(), (T[]) item.getMatches().toArray());
        }
    }

    @Override
    public void onCancelled(FirebaseError firebaseError) {

    }
}
