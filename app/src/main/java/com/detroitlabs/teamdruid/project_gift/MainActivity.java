package com.detroitlabs.teamdruid.project_gift;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;

import com.detroitlabs.teamdruid.project_gift.Fragments.Zodiac;


public class MainActivity extends Activity {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        //Making changes here, and to fragment_main layout to get to my own fragment
        private Button mButton;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            mButton = (Button) rootView.findViewById(R.id.get_to_zodiac);
            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    final Zodiac zodiac = new Zodiac();

                    if (fragmentTransaction.isEmpty()) {


                        // Commit the transaction
                        fragmentTransaction.add(R.id.container, zodiac);
                        Log.v(LOG_TAG, "*********put the Zodiac fragment at the top");
                        fragmentTransaction.commit();
                        Log.v(LOG_TAG, "********COMMITTING!!");

                    }
                }
            });

            return rootView;
        }
    }
}
