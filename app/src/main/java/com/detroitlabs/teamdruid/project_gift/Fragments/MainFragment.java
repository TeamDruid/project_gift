package com.detroitlabs.teamdruid.project_gift.fragments;

import android.app.DialogFragment;
import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.detroitlabs.teamdruid.project_gift.R;
import com.detroitlabs.teamdruid.project_gift.adapters.AnimalPagerAdapter;
import com.detroitlabs.teamdruid.project_gift.models.AnimalModel;

import java.util.ArrayList;

/**
 * Created by elyseturner on 11/12/14.
 */
public class MainFragment extends android.support.v4.app.Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager);
        AnimalPagerAdapter animalPagerAdapter = new AnimalPagerAdapter(getFragmentManager(),new ArrayList<AnimalModel>());
        viewPager.setAdapter(animalPagerAdapter);
    }
}

