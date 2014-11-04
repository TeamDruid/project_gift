package com.detroitlabs.teamdruid.project_gift.Fragments;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.detroitlabs.teamdruid.project_gift.R;

/**
 * Created by elyseturner on 11/4/14.
 */
public class MainFragment extends Fragment {

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        // Font path
        String titleFontPath = "fonts/LaurenScript.ttf";
        String textFontPath = "fonts/Walkway Bold.ttf";
        String druidFontPath = "fonts/Walkway Bold.ttf";
        String interestsFontPath = "fonts/Walkway Bold.ttf";
        String zodiacFontPath = "fonts/Walkway Bold.ttf";
        // text view label
        TextView txtGhost = (TextView) rootView.findViewById(R.id.ghost);
        TextView txtBoilerPlate = (TextView) rootView.findViewById(R.id.boiler_plate);
        TextView txtDruid = (TextView) rootView.findViewById(R.id.druid_button);
        TextView txtInterests = (TextView) rootView.findViewById(R.id.interests_button);
        TextView txtZodiac= (TextView) rootView.findViewById(R.id.zodiac_button);

        // Loading Font Face
        Typeface tfMain = Typeface.createFromAsset(getActivity().getAssets(), titleFontPath);
        Typeface tfText = Typeface.createFromAsset(getActivity().getAssets(), textFontPath);
        Typeface tfDruid = Typeface.createFromAsset(getActivity().getAssets(), druidFontPath);
        Typeface tfInterests = Typeface.createFromAsset(getActivity().getAssets(), interestsFontPath);
        Typeface tfZodiac = Typeface.createFromAsset(getActivity().getAssets(), zodiacFontPath);
        // Applying font
        txtGhost.setTypeface(tfMain);
        txtBoilerPlate.setTypeface(tfText);
        txtDruid.setTypeface(tfDruid);
        txtInterests.setTypeface(tfInterests);
        txtZodiac.setTypeface(tfZodiac);

        return rootView;
    }
}