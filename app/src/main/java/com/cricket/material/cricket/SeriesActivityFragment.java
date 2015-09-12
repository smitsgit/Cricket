package com.cricket.material.cricket;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.cricket.material.cricket.CricketSummaryFB.Series;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class SeriesActivityFragment extends Fragment {
    private SeriesActivityAdapter mSeriesActivityAdapter;
    private Series mSeries;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSeriesActivityAdapter = new SeriesActivityAdapter(getActivity());

        mSeries = (Series) getActivity().getIntent().getParcelableExtra("SeriesData");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        List<com.cricket.material.cricket.CricketSummaryFB.Match> matches = mSeries.getMatches();
        for (com.cricket.material.cricket.CricketSummaryFB.Match match : matches) {
            mSeriesActivityAdapter.add(match);
        }


        View rootView = inflater.inflate(R.layout.fragment_series, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.listview_ongoing_matches_detail);
        listView.setAdapter(mSeriesActivityAdapter);

        return rootView;
    }
}
