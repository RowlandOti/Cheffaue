
package com.rowland.cheffaue.domain.payload;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecipeDetailPayload {

    @SerializedName("yield")
    @Expose
    private String yield;
    @SerializedName("nutritionEstimates")
    @Expose
    private List<NutritionEstimate> nutritionEstimates = null;
    @SerializedName("prepTimeInSeconds")
    @Expose
    private Integer prepTimeInSeconds;
    @SerializedName("totalTime")
    @Expose
    private String totalTime;
    @SerializedName("images")
    @Expose
    private List<Image> images = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("source")
    @Expose
    private Source source;
    @SerializedName("prepTime")
    @Expose
    private String prepTime;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("ingredientLines")
    @Expose
    private List<String> ingredientLines = null;
    @SerializedName("cookTime")
    @Expose
    private String cookTime;
    @SerializedName("attribution")
    @Expose
    private Attribution attribution;
    @SerializedName("numberOfServings")
    @Expose
    private Integer numberOfServings;
    @SerializedName("totalTimeInSeconds")
    @Expose
    private Integer totalTimeInSeconds;
    @SerializedName("attributes")
    @Expose
    private Attributes attributes;
    @SerializedName("cookTimeInSeconds")
    @Expose
    private Integer cookTimeInSeconds;
    @SerializedName("flavors")
    @Expose
    private Flavors flavors;
    @SerializedName("rating")
    @Expose
    private Integer rating;

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

    public Attribution getAttribution() {
        return attribution;
    }

    public void setAttribution(Attribution attribution) {
        this.attribution = attribution;
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

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
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
        return "ClassPojo [prepTime = " + prepTime + ", totalTimeInSeconds = " + totalTimeInSeconds + ", yield = " + yield + ", ingredientLines = " + ingredientLines + ", cookTime = " + cookTime + ", id = " + id + ", source = " + source + ", prepTimeInSeconds = " + prepTimeInSeconds + ", numberOfServings = " + numberOfServings + ", name = " + name + ", flavors = " + flavors + ", images = " + images + ", rating = " + rating + ", attributes = " + attributes + ", cookTimeInSeconds = " + cookTimeInSeconds + ", totalTime = " + totalTime + ", attribution = " + attribution + ", nutritionEstimates = " + nutritionEstimates + "]";
    }

}
