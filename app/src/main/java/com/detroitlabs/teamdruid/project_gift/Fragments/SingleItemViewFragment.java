package com.detroitlabs.teamdruid.project_gift.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.detroitlabs.teamdruid.project_gift.R;
import com.detroitlabs.teamdruid.project_gift.models.EtsyObjectsModel;
import com.squareup.picasso.Picasso;

/**
 * Created by admin on 11/12/14.
 */
public class SingleItemViewFragment extends Fragment {
    private final String ETSY_OBJECT = "etsy object";
    private TextView titleView;
    private ImageView imageView;
    private TextView descriptionView;
    private TextView priceView;
    private Button addToFavoritesButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_singleitemview, container, false);
        titleView = (TextView) rootview.findViewById(R.id.single_item_title_text);
        imageView = (ImageView) rootview.findViewById(R.id.single_item_fullsize_image);
        descriptionView = (TextView) rootview.findViewById(R.id.single_item_description_text);
        priceView = (TextView) rootview.findViewById(R.id.single_item_price_text);
        addToFavoritesButton = (Button) rootview.findViewById(R.id.add_to_favorites);

        final EtsyObjectsModel etsyObjectsModelBundle = getArguments().getParcelable(ETSY_OBJECT);
        titleView.setText(etsyObjectsModelBundle.getmTitle());
        descriptionView.setText(etsyObjectsModelBundle.getmDescription());
        priceView.setText("$" + etsyObjectsModelBundle.getmPrice());
        Picasso.with(getActivity()).load(etsyObjectsModelBundle.getmFullSize()).into(imageView);

        addToFavoritesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FavoritesDialogFragment.addFavoritesItem(etsyObjectsModelBundle);
            }
        });

    return rootview;
    }

}
