package com.detroitlabs.teamdruid.project_gift.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.detroitlabs.teamdruid.project_gift.R;

/**
 * Created by elyseturner on 11/12/14.
 */
public class MainFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_main,container, false);

        //make fragment state pager adapter subclass? here is also where we populate the data set... animals.. arrays... models
        //set that adapter on view pager
    }
}
