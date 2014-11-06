package com.detroitlabs.teamdruid.project_gift.Fragments;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.detroitlabs.teamdruid.project_gift.Models.EtsyObjects;
import com.detroitlabs.teamdruid.project_gift.R;
import com.squareup.picasso.Picasso;

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

    @Override
    public int getCount() {
        return searchResults.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = LayoutInflater.from(getContext()).inflate(R.layout.search_results, parent, false);

        ImageView giftImage = (ImageView)rowView.findViewById(R.id.);
        TextView nameText = (TextView)rowView.findViewById(R.id.);
        TextView priceText = (TextView)rowView.findViewById(R.id.);

        EtsyObjects currentGift = searchResults.get(position);
        nameText.setText(currentGift.getmTitle());
        priceText.setText(currentGift.getmPrice());
        Picasso.with(getActivity()).load(currentGift.getmThumbnail()).into(giftImage);

        return rowView;
    }
}
