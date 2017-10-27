
package com.rowland.cheffaue.domain.payload;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageUrlsBySize {

    @SerializedName("90")
    @Expose
    private String _90;
    @SerializedName("360")
    @Expose
    private String _360;

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
}
