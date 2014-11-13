package com.detroitlabs.teamdruid.project_gift.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.detroitlabs.teamdruid.project_gift.fragments.AnimalPageFragment;
import com.detroitlabs.teamdruid.project_gift.models.AnimalModel;

import java.util.List;

/**
 * Created by elyseturner on 11/13/14.
 */
public class AnimalPagerAdapter extends FragmentStatePagerAdapter {

    private List<AnimalModel> animalModels;

    public AnimalPagerAdapter(FragmentManager fm, List<AnimalModel> animalModels) {
        super(fm);
        this.animalModels = animalModels;
    }

    @Override
    public Fragment getItem(int i) {
        return new AnimalPageFragment();
    }

    @Override
    public int getCount() {
//        return animalModels.size();
        return 5;
    }
}
