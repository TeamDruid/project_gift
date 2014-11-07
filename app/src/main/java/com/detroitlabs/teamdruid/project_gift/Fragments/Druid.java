package com.detroitlabs.teamdruid.project_gift.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.detroitlabs.teamdruid.project_gift.Activities.ResultsActivity;
import com.detroitlabs.teamdruid.project_gift.Requests.EtsyAPI;
import com.detroitlabs.teamdruid.project_gift.R;

/**
 * Created by kyleofori on 11/3/14.
 */
public class Druid extends Fragment implements View.OnClickListener {
    Button mYesButton;
    Button mNoButton;
    String keyword;
    private static final String DRUID_TAG = "druid tag";
    private static final String NOT_DRUID_TAG = "not druid tag";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_druid, container, false);
        mYesButton = (Button) rootView.findViewById(R.id.yes_druid);
        mYesButton.setOnClickListener(this);
        mNoButton = (Button) rootView.findViewById(R.id.no_druid);
        mNoButton.setOnClickListener(this);
        return rootView;

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.yes_druid:
                keyword = "Druid staff";
                Intent apiIntent1 = new Intent(getActivity(), ResultsActivity.class);
                apiIntent1.putExtra(DRUID_TAG, keyword);
                    break;
            case R.id.no_druid:
                keyword = "sad face";
                Intent apiIntent2 = new Intent(getActivity(), ResultsActivity.class);
                apiIntent2.putExtra(NOT_DRUID_TAG, keyword);
                    break;
        }
    }
}
