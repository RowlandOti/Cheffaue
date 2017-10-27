
package com.rowland.cheffaue.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Source implements Parcelable
{

    private String sourceDisplayName;

    private String sourceSiteUrl;

    private String sourceRecipeUrl;
    public final static Parcelable.Creator<Source> CREATOR = new Creator<Source>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Source createFromParcel(Parcel in) {
            return new Source(in);
        }

        public Source[] newArray(int size) {
            return (new Source[size]);
        }

    }
    ;

    protected Source(Parcel in) {
        this.sourceDisplayName = ((String) in.readValue((String.class.getClassLoader())));
        this.sourceSiteUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.sourceRecipeUrl = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Source() {
    }

    public String getSourceDisplayName() {
        return sourceDisplayName;
    }

    public void setSourceDisplayName(String sourceDisplayName) {
        this.sourceDisplayName = sourceDisplayName;
    }

    public String getSourceSiteUrl() {
        return sourceSiteUrl;
    }

    public void setSourceSiteUrl(String sourceSiteUrl) {
        this.sourceSiteUrl = sourceSiteUrl;
    }

    public String getSourceRecipeUrl() {
        return sourceRecipeUrl;
    }

    public void setSourceRecipeUrl(String sourceRecipeUrl) {
        this.sourceRecipeUrl = sourceRecipeUrl;
    }

    @Override
    public String toString() {
        return "Source [sourceSiteUrl = " + sourceSiteUrl + ", sourceDisplayName = " + sourceDisplayName + ", sourceRecipeUrl = " + sourceRecipeUrl + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(sourceDisplayName);
        dest.writeValue(sourceSiteUrl);
        dest.writeValue(sourceRecipeUrl);
    }

    public int describeContents() {
        return  0;
    }

}
