package com.rowland.cheffaue.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.rowland.cheffaue.domain.payload.RecipePayload;

import java.util.List;

/**
 * Created by Rowland on 10/24/2017.
 */

public class RecipeModel implements Parcelable {

    private String sourceDisplayName;

    private List<String> ingredients = null;

    private String id;

    private List<String> smallImageUrls = null;

    private String recipeName;

    private Integer totalTimeInSeconds;

    private RecipePayload.Attributes attributes;

    private Object flavors;

    private Integer rating;

    public RecipeModel() {
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

    public RecipePayload.Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(RecipePayload.Attributes attributes) {
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
        return "RecipeModel [id = " + id + ", ingredients = " + ingredients + ", recipeName = " + recipeName + ", totalTimeInSeconds = " + totalTimeInSeconds + ", smallImageUrls = " + smallImageUrls + ", sourceDisplayName = " + sourceDisplayName + ", flavors = " + flavors + ", rating = " + rating + ", attributes = " + attributes + ", imageUrlsBySize = " + "]";
    }

    protected RecipeModel(Parcel in) {
        this.sourceDisplayName = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.ingredients, (java.lang.String.class.getClassLoader()));
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.smallImageUrls, (java.lang.String.class.getClassLoader()));
        this.recipeName = ((String) in.readValue((String.class.getClassLoader())));
        this.totalTimeInSeconds = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.attributes = ((RecipePayload.Attributes) in.readValue((RecipePayload.Attributes.class.getClassLoader())));
        this.flavors = ((Object) in.readValue((Object.class.getClassLoader())));
        this.rating = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public final static Parcelable.Creator<RecipeModel> CREATOR = new Creator<RecipeModel>() {

        @SuppressWarnings({"unchecked"})
        public RecipeModel createFromParcel(Parcel in) {
            return new RecipeModel(in);
        }

        public RecipeModel[] newArray(int size) {
            return (new RecipeModel[size]);
        }

    };

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(sourceDisplayName);
        dest.writeList(ingredients);
        dest.writeValue(id);
        dest.writeList(smallImageUrls);
        dest.writeValue(recipeName);
        dest.writeValue(totalTimeInSeconds);
        dest.writeValue(attributes);
        dest.writeValue(flavors);
        dest.writeValue(rating);
    }

    public int describeContents() {
        return 0;
    }

    public static class Attributes implements Parcelable {

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

        public final static Parcelable.Creator<Attributes> CREATOR = new Creator<Attributes>() {
            @SuppressWarnings({"unchecked"})
            public Attributes createFromParcel(Parcel in) {
                return new Attributes(in);
            }

            public Attributes[] newArray(int size) {
                return (new Attributes[size]);
            }
        };

        protected Attributes(Parcel in) {
            in.readList(this.course, (String.class.getClassLoader()));
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeList(course);
        }

        public int describeContents() {
            return 0;
        }
    }

}
