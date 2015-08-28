package com.cricket.material.cricket;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class OngoingMatchesAdapter extends ArrayAdapter<OngoingMatchDetail> {
    public OngoingMatchesAdapter(Context context, ArrayList<OngoingMatchDetail> matches) {
        super(context, 0, matches);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        OngoingMatchDetail match = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_ongoing_matches, parent, false);
        }
        // Lookup view for data population
        TextView matchDetail = (TextView) convertView.findViewById(R.id.list_item_date_match_detail);
        TextView team1Score = (TextView) convertView.findViewById(R.id.list_item_score_team1);
        TextView team2Score = (TextView) convertView.findViewById(R.id.list_item_score_team2);
        TextView matchResult = (TextView) convertView.findViewById(R.id.list_item_match_result);
        // Populate the data into the template view using the data object
        matchDetail.setText(match.matchDetail);
        team1Score.setText(match.team1Score);
        team2Score.setText(match.team2Score);
        matchResult.setText(match.matchResult);
        // Return the completed view to render on screen
        return convertView;
    }
}