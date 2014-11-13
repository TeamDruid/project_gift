package com.detroitlabs.teamdruid.project_gift.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.detroitlabs.teamdruid.project_gift.R;
import com.detroitlabs.teamdruid.project_gift.fragments.LaunchFragment;

public class MainActivity extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new LaunchFragment())
                    .commit();
        }

    }
}
