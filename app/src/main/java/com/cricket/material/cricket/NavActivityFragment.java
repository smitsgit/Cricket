package com.cricket.material.cricket;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

/**
 * A placeholder fragment containing a simple view.
 */
public class NavActivityFragment extends Fragment {
    private static final int THREE_FRAGMENTS = 3;
    private static final String TAG = NavActivityFragment.class.getSimpleName();
    private ViewPager mViewPager;
    private TabHost.TabContentFactory mFactory = new TabHost.TabContentFactory() {

        @Override
        public View createTabContent(String tag) {
            View v = new View(getActivity());
            v.setMinimumHeight(0);
            return v;
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_nav,
                container, false);
        mViewPager = (ViewPager) rootView.findViewById(R.id.pager);
        mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        mViewPager.setAdapter(new CustomerInnerPagerAdapter(getChildFragmentManager()));
        final TabHost tabHost = (TabHost) rootView
                .findViewById(android.R.id.tabhost);
        tabHost.setup();
        tabHost.addTab(tabHost.newTabSpec("Tab1").setIndicator(getActivity().getString(R.string.scores)).setContent(mFactory));
        tabHost.addTab(tabHost.newTabSpec("Tab2").setIndicator(getActivity().getString(R.string.news)).setContent(mFactory));
        tabHost.addTab(tabHost.newTabSpec("Tab3").setIndicator(getActivity().getString(R.string.series)).setContent(mFactory));
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                tabHost.setCurrentTab(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {

            @Override
            public void onTabChanged(String tabId) {
                if (tabId.equals("Tab1")) {
                    mViewPager.setCurrentItem(0);
                } else if (tabId.equals("Tab2")) {
                    mViewPager.setCurrentItem(1);
                } else if (tabId.equals("Tab3")){
                    mViewPager.setCurrentItem(2);
                }
            }
        });
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private class CustomerInnerPagerAdapter extends FragmentPagerAdapter {

        public CustomerInnerPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                     return new ScoresFragment();
                case 1:
                    return new NewsFragment();
                case 2:
                    return new OngoingMatchesFragment();
                default:
                    Log.d(TAG, "getItem ");
            }
            return null;
        }

        @Override
        public int getCount() {
            return THREE_FRAGMENTS;
        }

    }

}
