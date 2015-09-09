package com.cricket.material.cricket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.cricket.material.cricket.News.CricketNewsService;

/**
 * A placeholder fragment containing a simple view.
 */
public class NewsFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    public static final String NEWS_URL = "NEWS_URL";
    private static final String includes_news = "select * from cricket.news  where region=\"in\"";
    private NewsAdapter mNewsAdapter;

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

    public NewsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mNewsAdapter = new NewsAdapter(getActivity());
        /* No Retrofit Calls from Apps Anymore
        loadCricNewsData(includes_news);*/
    }

/*
    protected void loadCricNewsData(String includes) {
        CricketNewsService service = new CricketNewsService();
        service.loadCricNewsData(mNewsAdapter, includes);
    }
*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_news, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.listview_news);
        listView.setAdapter(mNewsAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                NewsDetail detail = (NewsDetail)adapterView.getItemAtPosition(position);

                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra(NEWS_URL, detail.getLink());
                startActivity(intent);
            }
        });

        return rootView;
    }
}
