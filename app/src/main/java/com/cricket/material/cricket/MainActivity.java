package com.cricket.material.cricket;

import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.cricket.material.cricket.LiveScore.LiveScoreService;
import com.cricket.material.cricket.LiveScore.LivescoreSummary;
import com.cricket.material.cricket.News.CricketNews;
import com.cricket.material.cricket.News.CricketNewsService;
import com.cricket.material.cricket.cricketsummary.CricketService;
import com.cricket.material.cricket.cricketsummary.CricketSummary;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {

    private static final String includes_past  = "select * from cricket.series.past";
    private static final String includes_ongoing = "select * from cricket.series.ongoing";
    private static final String includes_live = "select * from cricket.scorecard.live.summary";
    private static final String includes_news = "select * from cricket.news  where region=\"in\"";

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    public static final String TAG = MainActivity.class.getSimpleName();

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the action bar.
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        // When swiping between different sections, select the corresponding
        // tab. We can also use ActionBar.Tab#select() to do this if we have
        // a reference to the Tab.
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });

        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
            // Create a tab with text corresponding to the page title defined by
            // the adapter. Also specify this Activity object, which implements
            // the TabListener interface, as the callback (listener) for when
            // this tab is selected.
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(mSectionsPagerAdapter.getPageTitle(i))
                            .setTabListener(this));
        }

        //loadCrickSummaryData(includes_past);
        //loadLiveScoreData(includes_live);
        loadCricNewsData(includes_news);
    }


    protected void loadCrickSummaryData(String includes) {
        CricketService service = new CricketService();
        service.loadSummaryData(mCricCallback, includes);
    }

    protected void loadLiveScoreData(String includes) {
        LiveScoreService service = new LiveScoreService();
        service.loadLiveScoreData(mCricLiveScoreCallback, includes);
    }

    protected void loadCricNewsData(String includes) {
        CricketNewsService service = new CricketNewsService();
        service.loadCricNewsData(mCricNewsCallback, includes);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in
        // the ViewPager.
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }


    /* Callback for Ongoing / Past Tables */
    protected Callback<CricketSummary> mCricCallback = new Callback<CricketSummary>() {

        @Override
        public void success(CricketSummary cricketSummary, Response response) {
            Log.d(TAG, "success ");
        }

        @Override
        public void failure(RetrofitError error) {
            Log.d(TAG, "failure ");
        }
    };

    /* Callback for Live Score */
    protected Callback<LivescoreSummary> mCricLiveScoreCallback = new Callback<LivescoreSummary>() {

        @Override
        public void success(LivescoreSummary livescoreSummary, Response response) {
            Log.d(TAG, "success ");
        }

        @Override
        public void failure(RetrofitError error) {
            Log.d(TAG, "failure ");
        }
    };

    /* Callback for News Tables */
    protected Callback<CricketNews> mCricNewsCallback = new Callback<CricketNews>() {

        @Override
        public void success(CricketNews cricketNews, Response response) {
            Log.d(TAG, "success ");
        }

        @Override
        public void failure(RetrofitError error) {
            Log.d(TAG, "failure ");
        }
    };


}
