package com.detroitlabs.teamdruid.project_gift.Fragments;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.app.FragmentTransaction;
import android.util.Log;
import android.widget.Button;

import com.detroitlabs.teamdruid.project_gift.activities.MainActivity;
import com.detroitlabs.teamdruid.project_gift.R;

/**
 * Created by elyseturner on 11/4/14.
 */
public class MainFragment extends Fragment {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();

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
            //KO - Changing txtDruid to a button to connect to Dan's fragment.
        Button txtDruid = (Button) rootView.findViewById(R.id.druid_button);
        TextView txtInterests = (TextView) rootView.findViewById(R.id.interests_button);
            //KO - I changed txtZodiac to a Button so I can connect it to my fragment.
        Button txtZodiac= (Button) rootView.findViewById(R.id.zodiac_button);

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

        txtZodiac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                final Zodiac zodiac = new Zodiac();

                if (fragmentTransaction.isEmpty()) {

                    // Commit the transaction
                    fragmentTransaction.add(R.id.container, zodiac);
                    Log.v(LOG_TAG, "*********put the Zodiac fragment on screen");
                    fragmentTransaction.commit();
                    Log.v(LOG_TAG, "********committing the Zodiac fragment");

                }
            }
        });

        txtDruid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                final Druid druid = new Druid();

                if (fragmentTransaction.isEmpty()) {

                    // Commit the transaction
                    fragmentTransaction.add(R.id.container, druid);
                    Log.v(LOG_TAG, "*********put the Druid fragment on screen");
                    fragmentTransaction.commit();
                    Log.v(LOG_TAG, "********committing the Druid fragment");

                }
            }
        });

        txtInterests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                final Interests interests = new Interests();

                if (fragmentTransaction.isEmpty()) {

                    // Commit the transaction
                    fragmentTransaction.add(R.id.container, interests);
                    Log.v(LOG_TAG, "*********put the Interests fragment on screen");
                    fragmentTransaction.commit();
                    Log.v(LOG_TAG, "********committing the Interests fragment");

                }
            }
        });

        return rootView;
    }
}