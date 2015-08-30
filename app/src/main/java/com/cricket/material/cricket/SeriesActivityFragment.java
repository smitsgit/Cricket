package com.cricket.material.cricket;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * A placeholder fragment containing a simple view.
 */
public class SeriesActivityFragment extends Fragment {
    private OngoingMatchesAdapter mOngoingMatchesAdapter;

    public SeriesActivityFragment() {
        //mOngoingMatchesAdapter = new OngoingMatchesAdapter(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_series, container, false);
        //ListView listView = (ListView) rootView.findViewById(R.id.listview_ongoing_matches_detail);
        //listView.setAdapter(mOngoingMatchesAdapter);

        return rootView;
    }
}
