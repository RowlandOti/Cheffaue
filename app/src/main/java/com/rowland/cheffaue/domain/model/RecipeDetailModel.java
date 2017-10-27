
package com.rowland.cheffaue.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class RecipeDetailModel implements Parcelable {

    private String yield;

    private List<NutritionEstimate> nutritionEstimates = null;

    private Integer prepTimeInSeconds;

    private String totalTime;

    private List<Image> images = null;

    private String name;

    private Source source;

    private String prepTime;

    private String id;

    private List<String> ingredientLines = null;

    private String cookTime;

    private Integer numberOfServings;

    private Integer totalTimeInSeconds;

    private Integer cookTimeInSeconds;

    private Flavors flavors;

    private Integer rating;
    public final static Parcelable.Creator<RecipeDetailModel> CREATOR = new Creator<RecipeDetailModel>() {

        @SuppressWarnings({
                "unchecked"
        })
        public RecipeDetailModel createFromParcel(Parcel in) {
            return new RecipeDetailModel(in);
        }

        public RecipeDetailModel[] newArray(int size) {
            return (new RecipeDetailModel[size]);
        }

    };

    protected RecipeDetailModel(Parcel in) {
        this.yield = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.nutritionEstimates, (com.rowland.cheffaue.domain.model.NutritionEstimate.class.getClassLoader()));
        this.prepTimeInSeconds = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.totalTime = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.images, (com.rowland.cheffaue.domain.model.Image.class.getClassLoader()));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.source = ((Source) in.readValue((Source.class.getClassLoader())));
        this.prepTime = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.ingredientLines, (java.lang.String.class.getClassLoader()));
        this.cookTime = ((String) in.readValue((String.class.getClassLoader())));
        this.numberOfServings = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.totalTimeInSeconds = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.cookTimeInSeconds = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.flavors = ((Flavors) in.readValue((Flavors.class.getClassLoader())));
        this.rating = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public RecipeDetailModel() {
    }

    public String getYield() {
        return yield;
    }

    public void setYield(String yield) {
        this.yield = yield;
    }

    public List<NutritionEstimate> getNutritionEstimates() {
        return nutritionEstimates;
    }

    public void setNutritionEstimates(List<NutritionEstimate> nutritionEstimates) {
        this.nutritionEstimates = nutritionEstimates;
    }

    public Integer getPrepTimeInSeconds() {
        return prepTimeInSeconds;
    }

    public void setPrepTimeInSeconds(Integer prepTimeInSeconds) {
        this.prepTimeInSeconds = prepTimeInSeconds;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(String prepTime) {
        this.prepTime = prepTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getIngredientLines() {
        return ingredientLines;
    }

    public void setIngredientLines(List<String> ingredientLines) {
        this.ingredientLines = ingredientLines;
    }

    public String getCookTime() {
        return cookTime;
    }

    public void setCookTime(String cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getNumberOfServings() {
        return numberOfServings;
    }

    public void setNumberOfServings(Integer numberOfServings) {
        this.numberOfServings = numberOfServings;
    }

    public Integer getTotalTimeInSeconds() {
        return totalTimeInSeconds;
    }

    public void setTotalTimeInSeconds(Integer totalTimeInSeconds) {
        this.totalTimeInSeconds = totalTimeInSeconds;
    }

    public Integer getCookTimeInSeconds() {
        return cookTimeInSeconds;
    }

    public void setCookTimeInSeconds(Integer cookTimeInSeconds) {
        this.cookTimeInSeconds = cookTimeInSeconds;
    }

    public Flavors getFlavors() {
        return flavors;
    }

    public void setFlavors(Flavors flavors) {
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
        return "RecipeDetailPayload [prepTime = " + prepTime + ", totalTimeInSeconds = " + totalTimeInSeconds + ", yield = " + yield + ", ingredientLines = " + ingredientLines + ", cookTime = " + cookTime + ", id = " + id + ", source = " + source + ", prepTimeInSeconds = " + prepTimeInSeconds + ", numberOfServings = " + numberOfServings + ", name = " + name + ", flavors = " + flavors + ", images = " + images + ", rating = " + rating + ", cookTimeInSeconds = " + cookTimeInSeconds + ", totalTime = " + totalTime + ", nutritionEstimates = " + nutritionEstimates + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(yield);
        dest.writeList(nutritionEstimates);
        dest.writeValue(prepTimeInSeconds);
        dest.writeValue(totalTime);
        dest.writeList(images);
        dest.writeValue(name);
        dest.writeValue(source);
        dest.writeValue(prepTime);
        dest.writeValue(id);
        dest.writeList(ingredientLines);
        dest.writeValue(cookTime);
        dest.writeValue(numberOfServings);
        dest.writeValue(totalTimeInSeconds);
        dest.writeValue(cookTimeInSeconds);
        dest.writeValue(flavors);
        dest.writeValue(rating);
    }

    public int describeContents() {
        return 0;
    }

}
