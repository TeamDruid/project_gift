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
import com.squareup.picasso.Picasso;

/**
 * Created by admin on 11/13/14.
 */
public class FavoritesSingleItemViewFragment extends Fragment {
    private final String FAVORITES_POSITION = "favorites position";
    private TextView titleView;
    private ImageView imageView;
    private TextView descriptionView;
    private TextView priceView;
    private Button deleteButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_favorites_singleitemview, container, false);
        titleView = (TextView) rootview.findViewById(R.id.single_item_title_text);
        imageView = (ImageView) rootview.findViewById(R.id.single_item_fullsize_image);
        descriptionView = (TextView) rootview.findViewById(R.id.single_item_description_text);
        priceView = (TextView) rootview.findViewById(R.id.single_item_price_text);
        deleteButton = (Button) rootview.findViewById(R.id.delete_from_favorites_single_item_view);

        final int position = getArguments().getInt(FAVORITES_POSITION);
        titleView.setText(FavoritesDialogFragment.getFavoritesItem(position).getmTitle());
        descriptionView.setText(FavoritesDialogFragment.getFavoritesItem(position).getmDescription());
        priceView.setText("$" + FavoritesDialogFragment.getFavoritesItem(position).getmPrice());
        Picasso.with(getActivity()).load(FavoritesDialogFragment.getFavoritesItem(position).getmFullSize()).into(imageView);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FavoritesDialogFragment.removeFavoritesItem(position);
            }
        });

        return rootview;
    }
}


