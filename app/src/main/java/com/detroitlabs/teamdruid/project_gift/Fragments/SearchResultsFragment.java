package com.detroitlabs.teamdruid.project_gift.Fragments;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.detroitlabs.teamdruid.project_gift.Models.EtsyObjects;
import com.detroitlabs.teamdruid.project_gift.R;
import com.detroitlabs.teamdruid.project_gift.Requests.EtsyAPI;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anniedevine on 11/6/14.
 */
public class SearchResultsFragment extends ListFragment {
    ListView mainListView;
    ArrayAdapter mArrayAdapter;
    List<EtsyObjects> mResultsList = new ArrayList<EtsyObjects>();
    private static final String QUEUE = "queue";
    private static final String SEARCH_KEYWORD_TAG = "search_keyword_tag";

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ListView myListView = getListView();
        ResultsAdapter adapter = new ResultsAdapter(getActivity(), mResultsList);
        myListView.setAdapter(adapter);
        getArguments().getParcelableArrayList(QUEUE);
        EtsyAPI etsyAPI = new EtsyAPI(getArguments().getString(SEARCH_KEYWORD_TAG));

        etsyAPI.execute();
    }

    public class ResultsAdapter extends ArrayAdapter<EtsyObjects> {
        private List<EtsyObjects> searchResults;

        public ResultsAdapter(Context context, List<EtsyObjects> etsyObjects) {
            super(context, android.R.layout.simple_list_item_1, etsyObjects);
            searchResults = etsyObjects;
        }

        @Override
        public int getCount() {
            return searchResults.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View rowView = LayoutInflater.from(getContext()).inflate(R.layout.search_results, parent, false);

            ImageView giftImage = (ImageView)rowView.findViewById(R.id.gift_image);
            TextView nameText = (TextView)rowView.findViewById(R.id.name_text);
            TextView priceText = (TextView)rowView.findViewById(R.id.price_text);

            EtsyObjects currentGift = searchResults.get(position);
            nameText.setText(currentGift.getmTitle());
            priceText.setText(currentGift.getmPrice());
            Picasso.with(getActivity()).load(currentGift.getmThumbnail()).into(giftImage);

            return rowView;
        }
    }

    //This is a way we can pass the search results from the API.
    public static SearchResultsFragment newInstance(ArrayList searchResults) {
        SearchResultsFragment fragment = new SearchResultsFragment();
        Bundle results = new Bundle();
        results.putParcelableArrayList(QUEUE, searchResults);
        fragment.setArguments(results);
        return fragment;
    }


}
