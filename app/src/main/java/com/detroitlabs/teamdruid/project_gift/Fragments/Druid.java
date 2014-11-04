package com.detroitlabs.teamdruid.project_gift.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.detroitlabs.teamdruid.project_gift.R;

import java.util.zip.Inflater;

/**
 * Created by kyleofori on 11/3/14.
 */
public class Druid extends Fragment implements View.OnClickListener {
    Button mYesButton;
    Button mNoButton;


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
        
    }
}
