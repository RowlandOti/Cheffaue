
package com.rowland.cheffaue.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ImageUrlsBySize implements Parcelable {

    private String _90;

    private String _360;
    public final static Parcelable.Creator<ImageUrlsBySize> CREATOR = new Creator<ImageUrlsBySize>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ImageUrlsBySize createFromParcel(Parcel in) {
            return new ImageUrlsBySize(in);
        }

        public ImageUrlsBySize[] newArray(int size) {
            return (new ImageUrlsBySize[size]);
        }

    };

    protected ImageUrlsBySize(Parcel in) {
        this._90 = ((String) in.readValue((String.class.getClassLoader())));
        this._360 = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ImageUrlsBySize() {
    }

    public String get90() {
        return _90;
    }

    public void set90(String _90) {
        this._90 = _90;
    }

    public String get360() {
        return _360;
    }

    public void set360(String _360) {
        this._360 = _360;
    }

    @Override
    public String toString() {
        return "ImageUrlsBySize [90 = " + _90 + ", _360 = " + _360 + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(_90);
        dest.writeValue(_360);
    }

    public int describeContents() {
        return 0;
    }

}
