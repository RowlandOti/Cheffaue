
package com.rowland.cheffaue.domain.payload;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image implements Parcelable {

    @SerializedName("hostedSmallUrl")
    @Expose
    private String hostedSmallUrl;
    @SerializedName("hostedMediumUrl")
    @Expose
    private String hostedMediumUrl;
    @SerializedName("hostedLargeUrl")
    @Expose
    private String hostedLargeUrl;
    @SerializedName("imageUrlsBySize")
    @Expose
    private ImageUrlsBySize imageUrlsBySize;

    public String getHostedSmallUrl() {
        return hostedSmallUrl;
    }

    public void setHostedSmallUrl(String hostedSmallUrl) {
        this.hostedSmallUrl = hostedSmallUrl;
    }

    public String getHostedMediumUrl() {
        return hostedMediumUrl;
    }

    public void setHostedMediumUrl(String hostedMediumUrl) {
        this.hostedMediumUrl = hostedMediumUrl;
    }

    public String getHostedLargeUrl() {
        return hostedLargeUrl;
    }

    public void setHostedLargeUrl(String hostedLargeUrl) {
        this.hostedLargeUrl = hostedLargeUrl;
    }

    public ImageUrlsBySize getImageUrlsBySize() {
        return imageUrlsBySize;
    }

    public void setImageUrlsBySize(ImageUrlsBySize imageUrlsBySize) {
        this.imageUrlsBySize = imageUrlsBySize;
    }

    @Override
    public String toString() {
        return "Image [hostedMediumUrl = " + hostedMediumUrl + ", hostedSmallUrl = " + hostedSmallUrl + ", imageUrlsBySize = " + imageUrlsBySize + ", hostedLargeUrl = " + hostedLargeUrl + "]";
    }


    public final static Parcelable.Creator<Image> CREATOR = new Creator<Image>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Image createFromParcel(Parcel in) {
            return new Image(in);
        }

        public Image[] newArray(int size) {
            return (new Image[size]);
        }

    };

    protected Image(Parcel in) {
        this.hostedSmallUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.hostedMediumUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.hostedLargeUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.imageUrlsBySize = ((ImageUrlsBySize) in.readValue((ImageUrlsBySize.class.getClassLoader())));
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(hostedSmallUrl);
        dest.writeValue(hostedMediumUrl);
        dest.writeValue(hostedLargeUrl);
        dest.writeValue(imageUrlsBySize);
    }

    public int describeContents() {
        return 0;
    }


}
