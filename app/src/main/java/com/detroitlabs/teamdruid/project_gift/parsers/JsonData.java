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

  private String searchResults = "";
  private JSONObject jsonObject;
  private final String RESULTS_KEY = "results";
  private final String TITLE_KEY = "title";
  private final String DESCRIPTION_KEY = "description";
  private final String PRICE_KEY = "price";
  private final String IMAGE_KEY = "Images";
  private final String THUMBNAIL_KEY = "url_75x75";
  private final String FULL_SIZE_IMAGE_KEY = "url_570xN";
  public String title;
  public String description;
  public String price;
  public String fullSizeImage;
  public String thumbnailImage;
    public ArrayList<EtsyObjectsModel> etsyObjectsModelArrayList = new ArrayList<EtsyObjectsModel>();
    public EtsyObjectsModel etsyObject = new EtsyObjectsModel();

    public void setSearchResults(String result){
      searchResults = result;
  }

    public ArrayList<EtsyObjectsModel> parseJson(){
        try{
            jsonObject = new JSONObject(searchResults);
        }
        catch(JSONException e){
            Log.e("TAG PARSE", "exception in converting string to JSON");
        }
        try{
            JSONArray mResultsArray = jsonObject.getJSONArray("Results");
            for(int i = 0; i < mResultsArray.length(); i++) {
                EtsyObjectsModel mEtsyObject = new EtsyObjectsModel();
                JSONObject mTitleObject = mResultsArray.getJSONObject(i);
                title = mTitleObject.getString(TITLE_KEY);
                etsyObject.setmTitle(title);
                description = mTitleObject.getString(DESCRIPTION_KEY);
                etsyObject.setmDescription(description);
                price = mTitleObject.getString(PRICE_KEY);
                etsyObject.setmPrice(price);
                JSONArray mImageArray = mTitleObject.getJSONArray(IMAGE_KEY);
                JSONObject mImageObject = mImageArray.getJSONObject(0);
                thumbnailImage = mImageObject.getString(THUMBNAIL_KEY);
                etsyObject.setmThumbnail(thumbnailImage);
                fullSizeImage = mImageObject.getString(FULL_SIZE_IMAGE_KEY);
                etsyObject.setmFullSize(fullSizeImage);
                etsyObjectsModelArrayList.add(etsyObject);
            }
        }
        catch (JSONException e){
            Log.e("TAG RESULT ARRAY", "exception creating result array");
        }
        return etsyObjectsModelArrayList;
    }

}
