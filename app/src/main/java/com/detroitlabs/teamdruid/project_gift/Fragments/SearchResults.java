package com.detroitlabs.teamdruid.project_gift.Fragments;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.detroitlabs.teamdruid.project_gift.Models.EtsyObjects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anniedevine on 11/6/14.
 */
public class SearchResults extends ListFragment {
    ListView mainListView;
    ArrayAdapter mArrayAdapter;
    List<EtsyObjects> mResultsList = new ArrayList<EtsyObjects>();


    @Override
    public void onViewCreate(View view, Bundle savedInstanceState) {
        ListView myListView = getListView();
        ResultsAdapter adapter = new ResultsAdapter(getActivity(), mResultsList);
        myListView.setAdapter(adapter);
    }

    public class ResultsAdapter extends ArrayAdapter<EtsyObjects> {
        private List<EtsyObjects> searchResults;

        public ResultsAdapter(Context context, List<EtsyObjects> etsyObjects) {
            super(context, android.R.layout.simple_list_item_1, etsyObjects);
            searchResults = etsyObjects;
        }
    }

}
