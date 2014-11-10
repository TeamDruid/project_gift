package com.detroitlabs.teamdruid.project_gift.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.detroitlabs.teamdruid.project_gift.activities.ResultsActivity;
import com.detroitlabs.teamdruid.project_gift.R;

/**
 * Created by kyleofori on 11/3/14.
 */
public class DruidFragment extends Fragment implements View.OnClickListener {
    private static final String SEARCH_KEYWORD_TAG = "search_keyword_tag";
    private Button yesButton;
    private Button noButton;
    private String keyword;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_druid, container, false);
        yesButton = (Button) rootView.findViewById(R.id.yes_druid);
        yesButton.setOnClickListener(this);
        noButton = (Button) rootView.findViewById(R.id.no_druid);
        noButton.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.yes_druid:
                keyword = "Druid staff";
                Intent apiIntentYesDruid = new Intent(getActivity(), ResultsActivity.class);
                apiIntentYesDruid.putExtra(SEARCH_KEYWORD_TAG, keyword);
                startActivity(apiIntentYesDruid);
                    break;
            case R.id.no_druid:
                keyword = "sad face";
                Intent apiIntentNoDruid = new Intent(getActivity(), ResultsActivity.class);
                apiIntentNoDruid.putExtra(SEARCH_KEYWORD_TAG, keyword);
                startActivity(apiIntentNoDruid);
                break;
        }
    }
}
