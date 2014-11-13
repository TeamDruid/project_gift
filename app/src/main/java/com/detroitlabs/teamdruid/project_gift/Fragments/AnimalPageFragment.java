package com.detroitlabs.teamdruid.project_gift.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.detroitlabs.teamdruid.project_gift.R;

/**
 * Created by elyseturner on 11/13/14.
 */
public class AnimalPageFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_animal_page, container, false);
    }
}
