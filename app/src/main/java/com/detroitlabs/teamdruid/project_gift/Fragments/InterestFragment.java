package com.detroitlabs.teamdruid.project_gift.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.detroitlabs.teamdruid.project_gift.activities.ResultsActivity;
import com.detroitlabs.teamdruid.project_gift.R;

/**
 * Created by kyleofori on 11/3/14.
 */
public class InterestFragment extends Fragment implements View.OnClickListener {

    private static final String SEARCH_KEYWORD_TAG = "search_keyword_tag";
    private EditText interestInput;
    private Button searchInterestsButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_interests, container, false);

        interestInput = (EditText) rootView.findViewById(R.id.interest);

        searchInterestsButton = (Button) rootView.findViewById(R.id.search_interests_ETSY);
        searchInterestsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String editTextString = interestInput.getText().toString();
                if (editTextString.length() < 1) {
                    Toast.makeText(getActivity(), "Please enter an interest first", Toast.LENGTH_SHORT);
                } else {
                    Intent apiIntent = new Intent(getActivity(), ResultsActivity.class);
                    apiIntent.putExtra(SEARCH_KEYWORD_TAG, interestInput.getText().toString());
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
