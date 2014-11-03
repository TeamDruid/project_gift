package com.detroitlabs.teamdruid.project_gift.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.detroitlabs.teamdruid.project_gift.R;

/**
 * Created by admin on 11/3/14.
 */
public class Zodiac extends Fragment {

    //I have no idea what to put in here.

    //That's not really true.

    //Zodiac needs to have its own layout of some sort,
    //but the code itself should include
    //-a way to search the user's birthday
    //-a way to match the birthday to a particular zodiac sign


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_zodiac, container, false);
        return rootView;
    }
}
