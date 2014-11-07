package com.detroitlabs.teamdruid.project_gift.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.detroitlabs.teamdruid.project_gift.Activities.ResultsActivity;
import com.detroitlabs.teamdruid.project_gift.Requests.EtsyAPI;
import com.detroitlabs.teamdruid.project_gift.R;

/**
 * Created by kyleofori on 11/3/14.
 */
public class Interests extends Fragment implements View.OnClickListener {

    private EditText EditText1, EditText2, EditText3;
    Button searchInterestsButton;
    private static final String FIRST_INTEREST = "first interest";
//    private static final String SECOND_INTEREST = "second interest";
//    private static final String THIRD_INTEREST = "third interest";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_interests, container, false);

        EditText1 = (EditText) rootView.findViewById(R.id.interest1);
//        EditText2 = (EditText) rootView.findViewById(R.id.interest2);
//        EditText3 = (EditText) rootView.findViewById(R.id.interest3);

        searchInterestsButton = (Button) rootView.findViewById(R.id.search_interests_ETSY);
        searchInterestsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String editTextString = EditText1.getText().toString();
                if (editTextString.length() < 1) {
                    Toast.makeText(getActivity(), "Please enter an interest first", Toast.LENGTH_SHORT);
                } else {
                    Intent apiIntent = new Intent(getActivity(), ResultsActivity.class);
                    apiIntent.putExtra(FIRST_INTEREST, EditText1.getText().toString());
                    //      apiIntent.putExtra(SECOND_INTEREST, EditText2.getText().toString());
                    //      apiIntent.putExtra(THIRD_INTEREST, EditText3.getText().toString());
                    startActivity(apiIntent);
                }
            }
        });

        return rootView;

    }

    @Override
    public void onClick(View view) {

    }
}
