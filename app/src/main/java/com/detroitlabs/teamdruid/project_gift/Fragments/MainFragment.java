package com.detroitlabs.teamdruid.project_gift.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.detroitlabs.teamdruid.project_gift.R;
import com.detroitlabs.teamdruid.project_gift.activities.ViewPagerAdapterActivity;

/**
 * Created by elyseturner on 11/12/14.
 */
public class MainFragment extends Fragment{
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //make fragment state pager adapter subclass? here is also where we populate the data set... animals.. arrays... models
        //set that adapter on view pager

        return inflater.inflate(R.layout.fragment_main,container, false);

    }



    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPager = (ViewPager) view.findViewById(R.id.pager);
//        mPagerAdapter = new ViewPagerAdapterActivity(getFragmentManager());
        mPager.setAdapter(new ViewPagerAdapterActivity(getFragmentManager()));

    }
}

