package com.detroitlabs.teamdruid.project_gift.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.detroitlabs.teamdruid.project_gift.R;

/**
 * Created by admin on 11/3/14.
 */
public class Zodiac extends Fragment {
    private TextView mTextView;
    private TextView mTextView1;
    private EditText mEditText;
    private Button mButton;

    //Getter methods may come in handy later.
    public TextView getTextView() {
        return mTextView;
    }

    public TextView getTextView1() {
        return mTextView1;
    }

    public EditText getEditText() {
        return mEditText;
    }

    public Button getButton() {
        return mButton;
    }

    //I have no idea what to put in here.

    //That's not really true.

    //Zodiac needs to have its own layout of some sort, √
    //but the code itself should include
    //-a way to search the user's birthday
    //-a way to match the birthday to a particular zodiac sign


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_zodiac, container, false);

        mTextView = (TextView) rootView.findViewById(R.id.your_zodiac_sign_is);
        mTextView.setVisibility(View.INVISIBLE);

        mTextView1 = (TextView) rootView.findViewById(R.id.zodiac_sign);

        mEditText = (EditText) rootView.findViewById(R.id.year);

        mButton = (Button) rootView.findViewById(R.id.search_button);

        return rootView;
    }

    public void onEnterYear() { //I want this to be an on-click.

        int year = 0;
        String textInEditText = mEditText.getText().toString();


        try {
            year = Integer.parseInt(textInEditText);
        } catch (TypeNotPresentException e) { //Is this the type of exception I want?
            mTextView.setVisibility(View.VISIBLE);
            mTextView.setText(getString(R.string.invalid_date));
        }

        String yearText;

        //A very loose and bound to be inaccurate calculator of one's Chinese zodiac sign.
        //I could replace this with an API call. Are there Chinese zodiac APIs?

        //http://www.softpedia.com/get/Programming/SDK-DDK/Horoscope-API.shtml


        switch (year % 12) {
            case 0:
                yearText = getString(R.string.monkey);
                break;
            case 1:
                yearText = getString(R.string.rooster);
                break;
            case 2:
                yearText = getString(R.string.dog);
                break;
            case 3:
                yearText = getString(R.string.pig);
                break;
            case 4:
                yearText = getString(R.string.rat);
                break;
            case 5:
                yearText = getString(R.string.ox);
                break;
            case 6:
                yearText = getString(R.string.tiger);
                break;
            case 7:
                yearText = getString(R.string.rabbit);
                break;
            case 8:
                yearText = getString(R.string.dragon);
                break;
            case 9:
                yearText = getString(R.string.snake);
                break;
            case 10:
                yearText = getString(R.string.horse);
                break;
            case 11:
                yearText = getString(R.string.sheep);
                break;
            default:
                yearText = "You did not provide a valid date.";
        }
        mTextView.setVisibility(View.VISIBLE);
        mTextView1.setText(yearText);
    }
}
