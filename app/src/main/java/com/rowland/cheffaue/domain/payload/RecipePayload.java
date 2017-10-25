
package com.rowland.cheffaue.domain.payload;

import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Rowland on 10/24/2017.
 */
public class RecipePayload {

    @SerializedName("imageUrlsBySize")
    @Expose
    private ImageUrlsBySize imageUrlsBySize;
    @SerializedName("sourceDisplayName")
    @Expose
    private String sourceDisplayName;
    @SerializedName("ingredients")
    @Expose
    private List<String> ingredients = null;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("smallImageUrls")
    @Expose
    private List<String> smallImageUrls = null;
    @SerializedName("recipeName")
    @Expose
    private String recipeName;
    @SerializedName("totalTimeInSeconds")
    @Expose
    private Integer totalTimeInSeconds;
    @SerializedName("attributes")
    @Expose
    private Attributes attributes;
    @SerializedName("flavors")
    @Expose
    private Object flavors;
    @SerializedName("rating")
    @Expose
    private Integer rating;

    public RecipePayload() {
    }

    public ImageUrlsBySize getImageUrlsBySize() {
        return imageUrlsBySize;
    }

    public void setImageUrlsBySize(ImageUrlsBySize imageUrlsBySize) {
        this.imageUrlsBySize = imageUrlsBySize;
    }

    public String getSourceDisplayName() {
        return sourceDisplayName;
    }

    public void setSourceDisplayName(String sourceDisplayName) {
        this.sourceDisplayName = sourceDisplayName;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getSmallImageUrls() {
        return smallImageUrls;
    }

    public void setSmallImageUrls(List<String> smallImageUrls) {
        this.smallImageUrls = smallImageUrls;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public Integer getTotalTimeInSeconds() {
        return totalTimeInSeconds;
    }

    public void setTotalTimeInSeconds(Integer totalTimeInSeconds) {
        this.totalTimeInSeconds = totalTimeInSeconds;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public Object getFlavors() {
        return flavors;
    }

    public void setFlavors(Object flavors) {
        this.flavors = flavors;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "RecipePayload [id = " + id + ", ingredients = " + ingredients + ", recipeName = " + recipeName + ", totalTimeInSeconds = " + totalTimeInSeconds + ", smallImageUrls = " + smallImageUrls + ", sourceDisplayName = " + sourceDisplayName + ", flavors = " + flavors + ", rating = " + rating + ", attributes = " + attributes + ", imageUrlsBySize = " + imageUrlsBySize + "]";
    }

    public static class ImageUrlsBySize {

        @SerializedName("90")
        @Expose
        private String _90;

        public ImageUrlsBySize() {
        }

        public String get90() {
            return _90;
        }

        public void set90(String _90) {
            this._90 = _90;
        }

        @Override
        public String toString() {
            return "ImageUrlsBySize [90 = " + 90 + "]";
        }
    }

    public static class Attributes {

        @SerializedName("course")
        @Expose
        private List<String> course = null;


        public Attributes() {
        }

        public List<String> getCourse() {
            return course;
        }

        public void setCourse(List<String> course) {
            this.course = course;
        }

        @Override
        public String toString() {
            return "Attributes [course = " + course + "]";
        }
    }
}