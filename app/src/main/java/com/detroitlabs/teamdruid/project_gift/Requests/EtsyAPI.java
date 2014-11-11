package com.detroitlabs.teamdruid.project_gift.requests;

import android.os.AsyncTask;
import android.util.Log;
import com.detroitlabs.teamdruid.project_gift.parsers.JsonData;
import com.detroitlabs.teamdruid.project_gift.models.EtsyObjectsModel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.net.ssl.HttpsURLConnection;
/**
 * Created by admin on 11/3/14.
 */
public class EtsyAPI extends AsyncTask<Object, Void, String>{

    public interface OnDataLoadedListener {

        public void dataLoaded(ArrayList<EtsyObjectsModel> etsyObjectsesModels);

    }

    private final String API_KEY = "&api_key=rf882apukk32kmsqamjwej8w";
    private final String BASE_API = "https://openapi.etsy.com/v2/listings/active?";
    private final String SORTING_HAT = "&sort_on=score&sort_order=down";
    private final String RESULT_LIMIT = "limit=25";
    private final String SEARCH_TERM = "&keywords=";
    private final String INCLUDE_IMAGES = "&includes=Images";
    private String searchKeyword = "";
    private OnDataLoadedListener onDataLoadedListener;
    public String searchResult;
    public String fullURL;

    public EtsyAPI(String searchKeyword , OnDataLoadedListener onDataLoadedListener) {
        this.searchKeyword = searchKeyword;
        this.onDataLoadedListener = onDataLoadedListener;
    }

    @Override
    protected String doInBackground(Object[] objects) {
        InputStream inputStream;
        HttpsURLConnection urlConnection;
        try {
            StringBuilder mStringBuilder = new StringBuilder();
            fullURL = BASE_API + RESULT_LIMIT + INCLUDE_IMAGES + SEARCH_TERM + searchKeyword + SORTING_HAT + API_KEY;
            URL mEtsyUrl = new URL(fullURL);
            urlConnection = (HttpsURLConnection) mEtsyUrl.openConnection();
            urlConnection.setRequestMethod("GET");
            inputStream = urlConnection.getInputStream();
            BufferedReader mBufferReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = mBufferReader.readLine()) != null) {
                mStringBuilder.append(line);
            }
            searchResult = mStringBuilder.toString();
            inputStream.close();
            urlConnection.disconnect();
        }
        catch (MalformedURLException e) {
            Log.e("TAG URL", e.getLocalizedMessage());
        }
        catch (IOException e) {
            Log.e("TAG URL CONNECTOR", e.getLocalizedMessage());
        }
        return searchResult;
    }

    @Override
    protected void onPostExecute(String SearchResult) {
        super.onPostExecute(SearchResult);

        if (searchResult == null) {
            Log.v("NULL TAG", "null search results in Etsy post ex");
        }
        else {
            JsonData jsonData = new JsonData();
            jsonData.setSearchResults(searchResult);
            ArrayList<EtsyObjectsModel> jelly = jsonData.parseJson();
            onDataLoadedListener.dataLoaded(jelly);
        }
    }
}
