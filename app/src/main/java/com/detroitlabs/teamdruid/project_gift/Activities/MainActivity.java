package com.detroitlabs.teamdruid.project_gift.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.detroitlabs.teamdruid.project_gift.fragments.FavoritesDialogFragment;
import com.detroitlabs.teamdruid.project_gift.fragments.MainFragment;
import com.detroitlabs.teamdruid.project_gift.R;
import com.detroitlabs.teamdruid.project_gift.fragments.LaunchFragment;

public class MainActivity extends FragmentActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

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
