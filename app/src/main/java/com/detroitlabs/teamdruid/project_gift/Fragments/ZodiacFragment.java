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
import com.detroitlabs.teamdruid.project_gift.models.ZodiacSearchArrays;
import com.detroitlabs.teamdruid.project_gift.R;

import static java.lang.Math.abs;

/**
 * Created by admin on 11/3/14.
 */
public class ZodiacFragment extends Fragment implements View.OnClickListener {

    public ZodiacSearchArrays zodiacArrays = new ZodiacSearchArrays();

    private TextView txtYourZodiacSignIs;
    private TextView txtZodiacSign;
    private EditText edtChangeBirthYear;
    private String yearText = "";
    private String searchKeyword;
    private Button btnWhatsMyZodiacSign;

    private static final String SEARCH_KEYWORD_TAG = "search_keyword_tag";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_zodiac, container, false);

        txtYourZodiacSignIs = (TextView) rootView.findViewById(R.id.your_zodiac_sign_is);
        txtYourZodiacSignIs.setVisibility(View.INVISIBLE);

        txtZodiacSign = (TextView) rootView.findViewById(R.id.zodiac_sign);

        edtChangeBirthYear = (EditText) rootView.findViewById(R.id.year);

        btnWhatsMyZodiacSign = (Button) rootView.findViewById(R.id.search_button);
        btnWhatsMyZodiacSign.setOnClickListener(this);

        Button sendButton = (Button) rootView.findViewById(R.id.search_ETSY);
        sendButton.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.search_button:
                int year = ensureValidBirthYear();

                int input = (year + 12 * abs(year)) % 12;

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
                txtYourZodiacSignIs.setVisibility(View.VISIBLE);
                txtZodiacSign.setText(yearText);
                break;
            case R.id.search_ETSY:
                if (searchKeyword == null) {
                    Toast.makeText(getActivity(), "Please enter a year", Toast.LENGTH_SHORT).show();
                }

                Intent resultsIntent = new Intent(getActivity(), ResultsActivity.class);
                resultsIntent.putExtra(SEARCH_KEYWORD_TAG, searchKeyword);
                startActivity(resultsIntent);
                break;
        }
    }

    public int ensureValidBirthYear() {
        int year = 0;

        String textInEditText = edtChangeBirthYear.getText().toString();
        txtYourZodiacSignIs.setText(getString(R.string.your_zodiac_sign_is));
        txtZodiacSign.setVisibility(View.VISIBLE);

        try {
            year = Integer.parseInt(textInEditText);
        } catch (NumberFormatException e) {
            txtYourZodiacSignIs.setVisibility(View.VISIBLE);
            txtYourZodiacSignIs.setText(getString(R.string.invalid_date));
            txtZodiacSign.setVisibility(View.INVISIBLE);
        }

        return year;
    }
}
