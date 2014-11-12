package com.detroitlabs.teamdruid.project_gift.activities;

import android.app.Activity;
import android.os.Bundle;

import com.detroitlabs.teamdruid.project_gift.fragments.LaunchFragment;
import com.detroitlabs.teamdruid.project_gift.R;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new LaunchFragment())
                    .commit();
        }

    }
}
