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

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/* test */
public class NewsAdapter extends ArrayAdapter<NewsDetail> implements Callback<CricketNews>, ValueEventListener {

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
        NewsDetail news = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_news, parent, false);
        }

        ImageView thumb = (ImageView) convertView.findViewById(R.id.list_item_new_thumb);
        TextView author = (TextView) convertView.findViewById(R.id.list_item_news_author);
        TextView title = (TextView) convertView.findViewById(R.id.list_item_news_title);

        author.setText(news.author);
        title.setText(news.title);
        if (news.getUrl() != null) {
            Picasso.with(getContext())
                    .load(news.getUrl())
                    .noFade()
                    .into(thumb);
        }

        return convertView;
    }

    @Override
    public void success(CricketNews cricketNews, Response response) {
        Log.d(LOG_TAG, "success ");
    }

    @Override
    public void failure(RetrofitError error) {

    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Log.d(LOG_TAG, "onDataChange ");
        CricketNews cricketNews = dataSnapshot.getValue(CricketNews.class);
        List<Item> items = cricketNews.getItem();
        for (int i = 0; i < items.size(); i++) {
            NewsDetail newsData = new NewsDetail(items.get(i).getAuthor(), items.get(i).getTitle(), items.get(i).getThumburl(), items.get(i).getLink());
            add(newsData);
        }
    }

    @Override
    public void onCancelled(FirebaseError firebaseError) {
        Log.d(LOG_TAG, "onDataChange - FireBase");
    }
}