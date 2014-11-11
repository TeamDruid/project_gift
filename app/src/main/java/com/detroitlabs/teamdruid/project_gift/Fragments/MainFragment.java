package com.detroitlabs.teamdruid.project_gift.fragments;

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
    // Font path
    private final String TITLE_FONT_PATH = "fonts/LaurenScript.ttf";
    private final String TEXT_FONT_PATH = "fonts/Walkway Bold.ttf";
    private final String DRUID_FONT_PATH = "fonts/Walkway Bold.ttf";
    private final String INTERESTS_FONT_PATH = "fonts/Walkway Bold.ttf";
    private final String ZODIAC_FONT_PATH = "fonts/Walkway Bold.ttf";

    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);


        // text view label
        TextView txtGhost = (TextView) rootView.findViewById(R.id.ghost);

        TextView txtBoilerPlate = (TextView) rootView.findViewById(R.id.boiler_plate);

        Button txtDruid = (Button) rootView.findViewById(R.id.druid_button);

        TextView txtInterests = (TextView) rootView.findViewById(R.id.interests_button);

        Button txtZodiac= (Button) rootView.findViewById(R.id.zodiac_button);

        // Loading Font Face
        Typeface tfMain = Typeface.createFromAsset(getActivity().getAssets(), TITLE_FONT_PATH);
        Typeface tfText = Typeface.createFromAsset(getActivity().getAssets(), TEXT_FONT_PATH);
        Typeface tfDruid = Typeface.createFromAsset(getActivity().getAssets(), DRUID_FONT_PATH);
        Typeface tfInterests = Typeface.createFromAsset(getActivity().getAssets(), INTERESTS_FONT_PATH );
        Typeface tfZodiac = Typeface.createFromAsset(getActivity().getAssets(), ZODIAC_FONT_PATH);

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
                final DruidFragment druid = new DruidFragment();

                if (fragmentTransaction.isEmpty()) {

                    // Commit the transaction
                    fragmentTransaction.add(R.id.container, druid);
                    Log.d(LOG_TAG, "put the Druid fragment on screen");
                    fragmentTransaction.commit();
                    Log.d(LOG_TAG, "committing the Druid fragment");

                }
            }
        });

        txtInterests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                final InterestFragment interests = new InterestFragment();

                if (fragmentTransaction.isEmpty()) {

                    // Commit the transaction
                    fragmentTransaction.add(R.id.container, interests);
                    Log.d(LOG_TAG, "put the Interests fragment on screen");
                    fragmentTransaction.commit();
                    Log.d(LOG_TAG, "committing the Interests fragment");

                }
            }
        });

        return rootView;
    }
}