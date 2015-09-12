package com.cricket.material.cricket;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.cricket.material.cricket.CricketSummaryFB.Match;


public class SeriesActivityAdapter extends ArrayAdapter<Match> {

    private final String LOG_TAG = SeriesActivityAdapter.class.getSimpleName();

    public SeriesActivityAdapter(Context context) {
        super(context, 0);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Match match = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_ongoing_matches_detail, parent, false);
        }

        TextView matchno = (TextView) convertView.findViewById(R.id.ongoing_matches_matchno);
        matchno.setText(match.getMatchno());

        TextView matchvenue = (TextView) convertView.findViewById(R.id.ongoing_matches_venue);
        matchvenue.setText(match.getVenue());

        TextView matchdate = (TextView) convertView.findViewById(R.id.ongoing_matches_date);
        matchdate.setText(match.getDate());

        TextView team1 = (TextView) convertView.findViewById(R.id.ongoing_matches_team1);
        team1.setText(match.getTeam1());

        TextView team1score = (TextView) convertView.findViewById(R.id.ongoing_matches_team1_score);
        team1score.setText(match.getTeam1Score());

        TextView team2 = (TextView) convertView.findViewById(R.id.ongoing_matches_team2);
        team2.setText(match.getTeam2());

        TextView team2score = (TextView) convertView.findViewById(R.id.ongoing_matches_team2_score);
        team2score.setText(match.getTeam2Score());

        TextView result = (TextView) convertView.findViewById(R.id.ongoing_matches_result);
        result.setText(match.getResult());

        return convertView;
    }
}