package com.cricket.material.cricket;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.cricket.material.cricket.LiveScore.LivescoreSummary;
import com.cricket.material.cricket.News.CricketNews;

import retrofit.RetrofitError;
import retrofit.client.Response;

public class ScoresAdapter extends ArrayAdapter<ScoresDetail> implements retrofit.Callback<LivescoreSummary> {

    private final String LOG_TAG = ScoresAdapter.class.getSimpleName();

    public ScoresAdapter(Context context) {
        super(context, 0);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ScoresDetail match = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_scores, parent, false);
        }
        // Lookup view for data population
        TextView scores = (TextView) convertView.findViewById(R.id.scores_matchno);
        scores.setText(match.score);

        return convertView;
    }

    @Override
    public void success(LivescoreSummary livescoreSummary, Response response) {
        Log.d(LOG_TAG, "success ");

        // Filling dummy data
        // TODO: Replace dummy data
        for (int i = 0; i < 10; i++) {
            ScoresDetail scoresData = new ScoresDetail("Score " + i + ". ");
            add(scoresData);
        }
    }

    @Override
    public void failure(RetrofitError error) {

    }
}