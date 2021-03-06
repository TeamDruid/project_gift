package com.detroitlabs.teamdruid.project_gift.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by elyseturner on 11/5/14.
 */
public class EtsyObjectsModel implements Parcelable {

    private String mTitle = "";
    private String mDescription = "";
    private String mPrice = "";
    private String mThumbnail = "";
    private String mFullSize = "";

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmPrice() {
        return mPrice;
    }

    public void setmPrice(String mPrice) {
        this.mPrice = mPrice;
    }

    public String getmThumbnail() {
        return mThumbnail;
    }

    public void setmThumbnail(String Thumbnail) {
        this.mThumbnail = Thumbnail;
        //remember to add the pictures to the inflated views
    }

    public String getmFullSize() {
        return mFullSize;
    }

    public void setmFullSize(String mFullSize) {
        this.mFullSize = mFullSize;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mTitle);
        dest.writeString(this.mDescription);
        dest.writeString(this.mPrice);
        dest.writeString(this.mThumbnail);
        dest.writeString(this.mFullSize);
    }

    public EtsyObjectsModel() {
    }

    private EtsyObjectsModel(Parcel in) {
        this.mTitle = in.readString();
        this.mDescription = in.readString();
        this.mPrice = in.readString();
        this.mThumbnail = in.readString();
        this.mFullSize = in.readString();
    }

    public static final Parcelable.Creator<EtsyObjectsModel> CREATOR = new Parcelable.Creator<EtsyObjectsModel>() {
        public EtsyObjectsModel createFromParcel(Parcel source) {
            return new EtsyObjectsModel(source);
        }

        public EtsyObjectsModel[] newArray(int size) {
            return new EtsyObjectsModel[size];
        }
    };
}
