package com.detroitlabs.teamdruid.project_gift.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.detroitlabs.teamdruid.project_gift.activities.ResultsActivity;
import com.detroitlabs.teamdruid.project_gift.Models.ZodiacSearchArrays;
import com.detroitlabs.teamdruid.project_gift.R;

import static java.lang.Math.abs;

/**
 * Created by admin on 11/3/14.
 */
public class Zodiac extends Fragment {
    private TextView mTextView;
    private TextView mTextView1;
    private EditText mEditText;
    private Button mButton;
    private Button sendButton;

    private static final String SEARCH_KEYWORD_TAG = "search_keyword_tag";
    public ZodiacSearchArrays zodiacArrays = new ZodiacSearchArrays();
    private String searchKeyword;


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

    String yearText = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_zodiac, container, false);

        mTextView = (TextView) rootView.findViewById(R.id.your_zodiac_sign_is);
        mTextView.setVisibility(View.INVISIBLE);

        mTextView1 = (TextView) rootView.findViewById(R.id.zodiac_sign);

        mEditText = (EditText) rootView.findViewById(R.id.year);

        mButton = (Button) rootView.findViewById(R.id.search_button);
        mButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            int year = 0;

            String textInEditText = mEditText.getText().toString();
            mTextView.setText(getString(R.string.your_zodiac_sign_is));
            mTextView1.setVisibility(View.VISIBLE);



            try {
                year = Integer.parseInt(textInEditText);
            } catch (NumberFormatException e) { //Is this the type of exception I want?
                mTextView.setVisibility(View.VISIBLE);
                mTextView.setText(getString(R.string.invalid_date));
                mTextView1.setVisibility(View.INVISIBLE);
            }

            int input = (year + 12*abs(year))%12;

            //A very loose and bound to be inaccurate calculator of one's Chinese zodiac sign.
            //I could replace this with an API call. Are there Chinese zodiac APIs?

            //http://www.softpedia.com/get/Programming/SDK-DDK/Horoscope-API.shtml


            switch (input) {
                case 0:
                    yearText = getString(R.string.monkey);
                    searchKeyword = zodiacArrays.getMonkey();
                    break;
                case 1:
                    yearText = getString(R.string.rooster);
                    searchKeyword = zodiacArrays.getRooster();
                    break;
                case 2:
                    yearText = getString(R.string.dog);
                    searchKeyword = zodiacArrays.getDog();
                    break;
                case 3:
                    yearText = getString(R.string.pig);
                    searchKeyword = zodiacArrays.getPig();
                    break;
                case 4:
                    yearText = getString(R.string.rat);
                    searchKeyword = zodiacArrays.getRat();
                    break;
                case 5:
                    yearText = getString(R.string.ox);
                    searchKeyword = zodiacArrays.getOx();
                    break;
                case 6:
                    yearText = getString(R.string.tiger);
                    searchKeyword = zodiacArrays.getTiger();
                    break;
                case 7:
                    yearText = getString(R.string.rabbit);
                    searchKeyword = zodiacArrays.getRabbit();
                    break;
                case 8:
                    yearText = getString(R.string.dragon);
                    searchKeyword = zodiacArrays.getDragon();
                    break;
                case 9:
                    yearText = getString(R.string.snake);
                    searchKeyword = zodiacArrays.getSnake();
                    break;
                case 10:
                    yearText = getString(R.string.horse);
                    searchKeyword = zodiacArrays.getHorse();
                    break;
                case 11:
                    yearText = getString(R.string.sheep);
                    searchKeyword = zodiacArrays.getSheep();
                    break;
                default:
                    break;
            }
            mTextView.setVisibility(View.VISIBLE);
            mTextView1.setText(yearText);

        }

        });

        sendButton = (Button) rootView.findViewById(R.id.search_ETSY);
        sendButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (searchKeyword == null) {
                    Toast.makeText(getActivity(), "Please enter a year", Toast.LENGTH_SHORT);
                }

                Intent resultsIntent = new Intent(getActivity(), ResultsActivity.class);
                resultsIntent.putExtra(SEARCH_KEYWORD_TAG, searchKeyword);
                startActivity(resultsIntent);
            }
        });

        return rootView;
    }

}
