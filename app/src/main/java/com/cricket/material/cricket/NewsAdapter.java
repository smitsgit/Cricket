package com.cricket.material.cricket;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cricket.material.cricket.News.CricketNews;
import com.cricket.material.cricket.News.Item;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit.RetrofitError;
import retrofit.client.Response;

public class NewsAdapter extends ArrayAdapter<NewsDetail> implements  retrofit.Callback<CricketNews> {

    private final String LOG_TAG = NewsAdapter.class.getSimpleName();
    public NewsAdapter(Context context) {
        super(context, 0);
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
        thumb.setImageResource(R.drawable.ic_drawer);
        if (news.getUrl() != null) {
            Picasso.with(getContext())
                    .load(news.getUrl())
                    .noFade()
                    .into(thumb);
        } else {
            // Setting some dummy image if image is missing
            // TODO: Take a call on default new image
            String tempUrl = "https://s.yimg.com/qx/cricket/fufp/images/4_l-11-2-2012-b8ce58599a586b164189b090b45c07e1.png";
            Picasso.with(getContext())
                    .load(tempUrl)
                    .noFade()
                    .into(thumb);
        }

        return convertView;
    }

    @Override
    public void success(CricketNews cricketNews, Response response) {
        Log.d(LOG_TAG, "success ");

        List<Item> items = cricketNews.getQuery().getResults().getItem();
        for (int i = 0; i < items.size(); i++) {
            NewsDetail newsData = new NewsDetail(items.get(i).getAuthor(), items.get(i).getTitle(), items.get(i).getThumburl(), items.get(i).getLink());
            add(newsData);
        }
    }

    @Override
    public void failure(RetrofitError error) {

    }
}