package com.detroitlabs.teamdruid.project_gift.activities;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.detroitlabs.teamdruid.project_gift.fragments.SearchResultsFragment;
import com.detroitlabs.teamdruid.project_gift.R;

/**
 * Created by anniedevine on 11/6/14.
 */
public class ResultsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            Bundle searchKeyword = getIntent().getExtras();
            SearchResultsFragment fragInfo = new SearchResultsFragment();
            fragInfo.setArguments(searchKeyword);
            transaction.replace(R.id.container, fragInfo);
            transaction.commit();
        }
    }

}
