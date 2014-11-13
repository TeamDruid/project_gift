package com.detroitlabs.teamdruid.project_gift.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.detroitlabs.teamdruid.project_gift.fragments.FavoritesDialogFragment;
import com.detroitlabs.teamdruid.project_gift.fragments.MainFragment;
import com.detroitlabs.teamdruid.project_gift.R;

public class MainActivity extends Activity {

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
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new MainFragment())
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
