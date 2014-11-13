package com.detroitlabs.teamdruid.project_gift.fragments;

import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.detroitlabs.teamdruid.project_gift.R;
import com.detroitlabs.teamdruid.project_gift.models.EtsyObjectsModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by admin on 11/12/14.
 */
public class FavoritesDialogFragment extends DialogFragment {
    private final String FAVORITES_POSITION = "favorites position";
    private ListView listView;
    private static ArrayList<EtsyObjectsModel> favoritesArray = new ArrayList<EtsyObjectsModel>();
    public Button deleteButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final FavortiesAdapter adapter = new FavortiesAdapter(getActivity());
        listView = new ListView(getActivity());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {
                FavoritesSingleItemViewFragment favoriteSingleItemView = new FavoritesSingleItemViewFragment();
                EtsyObjectsModel etsyObjectsModel = (EtsyObjectsModel) listView.getAdapter().getItem(position);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

                if (fragmentTransaction.isEmpty()) {
                    Bundle bundle = new Bundle();
                    bundle.putInt(FAVORITES_POSITION, position);
                    favoriteSingleItemView.setArguments(bundle);
                    fragmentTransaction.replace(R.id.container, favoriteSingleItemView);
                    fragmentTransaction.commit();
                }
            }
        });
        return new ListView(getActivity());
    }

    public static EtsyObjectsModel getFavoritesItem (int position) {
        EtsyObjectsModel currentItem = favoritesArray.get(position);
        return currentItem;
    }

    public static void removeFavoritesItem (int position) {
        favoritesArray.remove(position);
    }

    public static void addFavoritesItem(EtsyObjectsModel itemToAdd) {
        favoritesArray.add(itemToAdd);
    }

    public class FavortiesAdapter extends ArrayAdapter<EtsyObjectsModel> {

        public FavortiesAdapter(Context context) {
            super(context, android.R.layout.simple_list_item_1);
        }

        @Override
        public int getCount() {
            return favoritesArray.size();
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View rowView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_favorites_dialog, parent, false);
            deleteButton = (Button) rowView.findViewById(R.id.delete_button);
            ImageView giftImage = (ImageView)rowView.findViewById(R.id.gift_image);
            TextView nameText = (TextView)rowView.findViewById(R.id.name_text);
            TextView priceText = (TextView)rowView.findViewById(R.id.price_text);

            EtsyObjectsModel currentGift = favoritesArray.get(position);
            nameText.setText(currentGift.getmTitle());
            priceText.setText("$" + currentGift.getmPrice());
            Picasso.with(getActivity()).load(currentGift.getmThumbnail()).into(giftImage);

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    favoritesArray.remove(listView.getAdapter().getItem(position));
                }
            });

            return rowView;
        }
    }
}
