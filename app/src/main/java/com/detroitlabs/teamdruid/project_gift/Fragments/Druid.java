package com.detroitlabs.teamdruid.project_gift.Fragments;

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
public class Druid extends Fragment implements View.OnClickListener {
    Button mYesButton;
    Button mNoButton;
    String keyword;
    private static final String SEARCH_KEYWORD_TAG = "search_keyword_tag";

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
                apiIntent1.putExtra(SEARCH_KEYWORD_TAG, keyword);
                startActivity(apiIntent1);
                    break;
            case R.id.no_druid:
                keyword = "sad face";
                Intent apiIntent2 = new Intent(getActivity(), ResultsActivity.class);
                apiIntent2.putExtra(SEARCH_KEYWORD_TAG, keyword);
                startActivity(apiIntent2);
                break;
        }
    }
}
