package com.cricket.material.cricket;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by smitald on 9/9/2015.
 */
public class TeamInfoFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final String includes_live = "select * from cricket.scorecard.live.summary";
    private TeamInfoAdapter mTeamInfoAdapter;


    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static TeamInfoFragment newInstance(int sectionNumber) {
        TeamInfoFragment fragment = new TeamInfoFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public TeamInfoFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTeamInfoAdapter = new TeamInfoAdapter(getActivity());
        /* No Retrofit Calls from Apps Anymore
        loadLiveScoreData(includes_live); */
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_teaminfo, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.listview_teams);
        listView.setAdapter(mTeamInfoAdapter);


//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                // CursorAdapter returns a cursor at the correct position for getItem(), or null
//                // if it cannot seek to that position.
//                Cursor cursor = (Cursor) adapterView.getItemAtPosition(position);
//                if (cursor != null) {
//                    //do nothing
//                }
//            }
//        });

        return rootView;
    }
}
