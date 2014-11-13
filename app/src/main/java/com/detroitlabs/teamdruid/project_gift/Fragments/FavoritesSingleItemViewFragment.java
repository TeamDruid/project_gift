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
 * Created by admin on 11/13/14.
 */
public class FavoritesSingleItemViewFragment extends Fragment {
    private final String FAVORITES_POSITION = "favorites position";
    private final String FAVORITES_ITEM = "favorites item";
    private TextView titleView;
    private ImageView imageView;
    private TextView descriptionView;
    private TextView priceView;
    private Button deleteButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final int objectPosition = getArguments().getInt(FAVORITES_POSITION);
        View rootview = inflater.inflate(R.layout.fragment_favorites_singleitemview, container, false);
        titleView = (TextView) rootview.findViewById(R.id.single_item_title_text);
        imageView = (ImageView) rootview.findViewById(R.id.single_item_fullsize_image);
        descriptionView = (TextView) rootview.findViewById(R.id.single_item_description_text);
        priceView = (TextView) rootview.findViewById(R.id.single_item_price_text);
        deleteButton = (Button) rootview.findViewById(R.id.delete_from_favorites_single_item_view);

        final EtsyObjectsModel singleItem = getArguments().getParcelable(FAVORITES_ITEM);
        titleView.setText(singleItem.getmTitle());
        descriptionView.setText(singleItem.getmDescription());
        priceView.setText("$" + singleItem.getmPrice());
        Picasso.with(getActivity()).load(singleItem.getmFullSize()).into(imageView);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FavoritesDialogFragment.removeFavoritesItem(objectPosition);
            }
        });

        return rootview;
    }
}


