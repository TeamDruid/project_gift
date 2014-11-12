package com.detroitlabs.teamdruid.project_gift.parsers;

import android.util.Log;
import com.detroitlabs.teamdruid.project_gift.models.EtsyObjectsModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

/**
 * Created by elyseturner on 11/5/14.
 */
public class JsonData {
  private String mSearchResults = "";
  JSONObject mJsonObject;
  private final String RESULTS_KEY = "results";
  private final String TITLE_KEY = "title";
  private final String DESCRIPTION_KEY = "description";
  private final String PRICE_KEY = "price";
  private final String IMAGE_KEY = "Images";
  private final String THUMBNAIL_KEY = "url_75x75";
  private final String FULL_SIZE_IMAGE_KEY = "url_570xN";
  public String mTitle;
  public String mDescription;
  public String mPrice;
  public String mThumbnail;
  public String mFullSize;
  public ArrayList<EtsyObjectsModel> mEtsyObjectsModelArrayList = new ArrayList<EtsyObjectsModel>();

    public void setSearchResults(String result){
      mSearchResults = result;
  }

    public ArrayList<EtsyObjectsModel> parseJson(){
        try{
            mJsonObject = new JSONObject(mSearchResults);
        }
        catch(JSONException e){
            Log.e("TAG PARSE", "exception in converting string to JSON");
        }

        try{
            JSONArray mResultsArray = mJsonObject.getJSONArray(RESULTS_KEY);
            for(int i = 0; i < mResultsArray.length(); i++) {
                EtsyObjectsModel mEtsyObject = new EtsyObjectsModel();

                JSONObject mTitleObject = mResultsArray.getJSONObject(i);
                mTitle = mTitleObject.getString(TITLE_KEY);
                mEtsyObject.setmTitle(mTitle);

                mDescription = mTitleObject.getString(DESCRIPTION_KEY);
                mEtsyObject.setmDescription(mDescription);

                mPrice = mTitleObject.getString(PRICE_KEY);
                mEtsyObject.setmPrice(mPrice);

                JSONArray mImageArray = mTitleObject.getJSONArray(IMAGE_KEY);
                JSONObject mImageObject = mImageArray.getJSONObject(0);
                mThumbnail = mImageObject.getString(THUMBNAIL_KEY);
                mEtsyObject.setmThumbnail(mThumbnail);

                mFullSize = mImageObject.getString(FULL_SIZE_IMAGE_KEY);
                mEtsyObject.setmFullSize(mFullSize);

                mEtsyObjectsModelArrayList.add(mEtsyObject);
            }
        }
        catch (JSONException e){
            Log.e("TAG RESULT ARRAY", "exception creating result array");
        }

        return mEtsyObjectsModelArrayList;
    }

}
