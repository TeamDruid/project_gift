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
public class LaunchFragment extends Fragment {
    // Font path
    private final String TITLE_FONT_PATH = "fonts/LaurenScript.ttf";
    private final String TEXT_FONT_PATH = "fonts/Walkway Bold.ttf";
    private final String DRUID_FONT_PATH = "fonts/Walkway Bold.ttf";
    private final String INTERESTS_FONT_PATH = "fonts/Walkway Bold.ttf";
    private final String ZODIAC_FONT_PATH = "fonts/Walkway Bold.ttf";

    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    public LaunchFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_launch, container, false);


        // text view label
        TextView txtGhost = (TextView) rootView.findViewById(R.id.ghost);

        TextView txtBoilerPlate = (TextView) rootView.findViewById(R.id.boiler_plate);

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
        txtZodiac.setTypeface(tfZodiac);

        txtZodiac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final FragmentTransaction fragmentTransaction = getActivity().getFragmentManager().beginTransaction();
                final MainFragment mainFragment = new MainFragment();

                if (fragmentTransaction.isEmpty()) {

                    // Commit the transaction
                    fragmentTransaction.replace(R.id.container, mainFragment);
                    Log.v(LOG_TAG, "*********put the Zodiac fragment on screen");
                    fragmentTransaction.commit();
                    Log.v(LOG_TAG, "********committing the Zodiac fragment");

                }
            }
        });


        return rootView;
    }
}