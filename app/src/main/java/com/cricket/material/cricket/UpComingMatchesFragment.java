package com.cricket.material.cricket;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.cricket.material.cricket.Upcoming.Match;


/**
 * Created by smitald on 9/4/2015.
 */
public class UpComingMatchesFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    public static final String NEWS_URL = "NEWS_URL";
    private static final String includes_news = "select * from cricket.news  where region=\"in\"";
    private SimpleSectionAdapter<Match> mAdapter;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static NewsFragment newInstance(int sectionNumber) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public UpComingMatchesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_upcoming, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.listview_upcoming);
        mAdapter = new SimpleSectionAdapter<Match>(listView, R.layout.upcoming_match_header,
                R.layout.upcoming_match_item) {

            @Override
            public void onSectionItemClick(Match item) {

            }
        };
        listView.setAdapter(mAdapter);
        return rootView;
    }
}
