package com.cricket.material.cricket;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private OngoingMatchesAdapter mOngoingMatchesAdapter;


    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public PlaceholderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        ArrayList<OngoingMatchDetail> matches = new ArrayList<>();

        mOngoingMatchesAdapter =
                new OngoingMatchesAdapter(getActivity(), matches);

        OngoingMatchDetail match1 = new OngoingMatchDetail("3rd ODI at Durban", "SA 287/7", "NZ 19/1", "NZ needs 262 runs");
        mOngoingMatchesAdapter.add(match1);

        OngoingMatchDetail match2 = new OngoingMatchDetail("3rd ODI at Durban", "SA 287/7", "NZ 19/1", "NZ needs 262 runs");
        mOngoingMatchesAdapter.add(match2);

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.listview_ongoing_matches);
        listView.setAdapter(mOngoingMatchesAdapter);

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
