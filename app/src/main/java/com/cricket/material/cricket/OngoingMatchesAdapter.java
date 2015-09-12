package com.cricket.material.cricket;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.cricket.material.cricket.CricketSummaryFB.Series;
import com.cricket.material.cricket.SeriesFB.Ongoing;
import com.cricket.material.cricket.SeriesFB.Past;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.List;

public class OngoingMatchesAdapter extends ArrayAdapter<Series> implements  ValueEventListener {

    private Firebase mRef;

    public OngoingMatchesAdapter(Context context) {
        super(context, 0);
        Firebase.setAndroidContext(context);
        mRef = new Firebase("https://coolapi.firebaseio.com/cricsummary");
        mRef.addValueEventListener(this);
    }
    private final String LOG_TAG = OngoingMatchesAdapter.class.getSimpleName();

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Series seriesInfo = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_ongoing_matches, parent, false);
        }

        TextView series = (TextView) convertView.findViewById(R.id.list_item_series);
        series.setText(seriesInfo.getSeriesName());

        return convertView;
    }


    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Log.d("##############", "onDataChange ongoing");

        Ongoing ongoing = dataSnapshot.child("ongoing").getValue(Ongoing.class);

        List<com.cricket.material.cricket.CricketSummaryFB.Series> ongoingSeries = ongoing.getSeries();

        for (Series series : ongoingSeries) {
            add(series);
        }

        Past past = dataSnapshot.child("past").getValue(Past.class);

        List<com.cricket.material.cricket.CricketSummaryFB.Series> pastSeries = past.getSeries();

        for (Series series : pastSeries) {
            add(series);
        }
    }

    @Override
    public void onCancelled(FirebaseError firebaseError) {

    }
}