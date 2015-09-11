package com.cricket.material.cricket;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.cricket.material.cricket.CricketSummaryFB.Series;
import com.cricket.material.cricket.NewsFB.Item;
import com.cricket.material.cricket.cricketsummary.CricketService;

/**
 * A placeholder fragment containing a simple view.
 */
public class OngoingMatchesFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final String includes_past  = "select * from cricket.series.past";
    private static final String includes_ongoing = "select * from cricket.series.ongoing";
    private OngoingMatchesAdapter mOngoingMatchesAdapter;


    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static OngoingMatchesFragment newInstance(int sectionNumber) {
        OngoingMatchesFragment fragment = new OngoingMatchesFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public OngoingMatchesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mOngoingMatchesAdapter = new OngoingMatchesAdapter(getActivity());
        /* No Retrofit Calls from Apps Anymore
        loadCrickSummaryData(includes_past);*/
    }

/*    protected void loadCrickSummaryData(String includes) {
        CricketService service = new CricketService();
        service.loadSummaryData(mOngoingMatchesAdapter, includes);
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_ongoing_matches, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.listview_ongoing_matches);
        listView.setAdapter(mOngoingMatchesAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Series series = (Series)adapterView.getItemAtPosition(position);

                Intent intent = new Intent(getActivity(), SeriesActivity.class);
                //intent.putExtra(NEWS_URL, newsItem.getLink());
                startActivity(intent);
            }
        });

        return rootView;
    }
}
