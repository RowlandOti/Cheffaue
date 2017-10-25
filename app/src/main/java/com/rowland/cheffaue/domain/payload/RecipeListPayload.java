
package com.rowland.cheffaue.domain.payload;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Rowland on 10/24/2017.
 */

public class RecipeListPayload implements Parcelable {

    @SerializedName("matches")
    @Expose
    private List<RecipePayload> recipePayloadList = null;

    public RecipeListPayload() {
    }

    public List<RecipePayload> getRecipePayloadList() {
        return recipePayloadList;
    }

    public void setRecipePayloadList(List<RecipePayload> recipePayloadList) {
        this.recipePayloadList = recipePayloadList;
    }

    @Override
    public String toString() {
        return "RecipeListPayload [recipePayloadList = " + recipePayloadList + "]";
    }

    public final static Parcelable.Creator<RecipeListPayload> CREATOR = new Creator<RecipeListPayload>() {

        @SuppressWarnings({"unchecked"})
        public RecipeListPayload createFromParcel(Parcel in) {
            return new RecipeListPayload(in);
        }

        public RecipeListPayload[] newArray(int size) {
            return (new RecipeListPayload[size]);
        }
    };

    protected RecipeListPayload(Parcel in) {
        in.readList(this.recipePayloadList, (RecipePayload.class.getClassLoader()));
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(recipePayloadList);
    }

    public int describeContents() {
        return 0;
    }
}
