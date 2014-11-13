package com.detroitlabs.teamdruid.project_gift.activities;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.detroitlabs.teamdruid.project_gift.fragments.FavoritesDialogFragment;
import com.detroitlabs.teamdruid.project_gift.fragments.SearchResultsFragment;
import com.detroitlabs.teamdruid.project_gift.R;

/**
 * Created by anniedevine on 11/6/14.
 */
public class ResultsActivity extends Activity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.results, menu);
        return super.onCreateOptionsMenu(menu);
    }

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.favorites:
                FavoritesDialogFragment favoritesDialog = new FavoritesDialogFragment();
                favoritesDialog.show(getFragmentManager(), "favs");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
