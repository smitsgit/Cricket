package com.cricket.material.cricket;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cricket.material.cricket.NewsFB.CricketNews;
import com.cricket.material.cricket.NewsFB.Item;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.List;

/* test */
public class NewsAdapter extends ArrayAdapter<Item> implements  ValueEventListener {

    private final String LOG_TAG = NewsAdapter.class.getSimpleName();
    private Firebase mRef;

    public NewsAdapter(Context context) {
        super(context, 0);
        Firebase.setAndroidContext(context);
        mRef = new Firebase("https://coolapi.firebaseio.com/news");
        mRef.addValueEventListener(this);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Item news = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_news, parent, false);
        }

        ImageView thumb = (ImageView) convertView.findViewById(R.id.list_item_new_thumb);
        TextView author = (TextView) convertView.findViewById(R.id.list_item_news_author);
        TextView title = (TextView) convertView.findViewById(R.id.list_item_news_title);

        author.setText(news.getAuthor());
        title.setText(news.getTitle());
        if (news.getThumburl() != null) {
            Picasso.with(getContext())
                    .load(news.getThumburl())
                    .noFade()
                    .into(thumb);
        }

        return convertView;
    }


    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Log.d(LOG_TAG, "onDataChange ");
        CricketNews cricketNews = dataSnapshot.getValue(CricketNews.class);
        List<Item> items = cricketNews.getItem();
        for (Item item : items) {
            add(item);
        }
    }

    @Override
    public void onCancelled(FirebaseError firebaseError) {
        Log.d(LOG_TAG, "onDataChange - FireBase");
    }
}