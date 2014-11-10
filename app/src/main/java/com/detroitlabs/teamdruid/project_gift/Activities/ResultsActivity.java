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

    //call get intent.getextras
//    use the bundle from get extras to set the arguments of the fragment that you're starting'


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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
}
