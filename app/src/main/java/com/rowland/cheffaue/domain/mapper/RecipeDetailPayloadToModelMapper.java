package com.rowland.cheffaue.domain.mapper;

import com.rowland.cheffaue.domain.model.RecipeDetailModel;
import com.rowland.cheffaue.domain.payload.RecipeDetailPayload;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Mapper class used to transform {@link RecipeDetailPayload} (in the data layer) to {@link RecipeDetailModel} in the
 * domain layer.
 * <p>
 * Created by Rowland on 10/25/2017.
 */

public class RecipeDetailPayloadToModelMapper {

    /**
     * Transform a {@link RecipeDetailPayload} into an {@link RecipeDetailModel}.
     *
     * @param payload Object to be transformed.
     * @return {@link RecipeDetailModel} if valid {@link RecipeDetailPayload} otherwise null.
     */
    public static RecipeDetailModel transform(RecipeDetailPayload payload) throws NoSuchFieldException, IllegalAccessException {
        RecipeDetailModel recipe = null;
        if (payload != null) {
            recipe = new RecipeDetailModel();
            recipe.setId(payload.getId());
            recipe.setName(payload.getName());
            recipe.setNumberOfServings(payload.getNumberOfServings());
            recipe.setCookTime(payload.getCookTime());
            recipe.setCookTimeInSeconds(payload.getCookTimeInSeconds());
            recipe.setPrepTime(payload.getPrepTime());
            recipe.setPrepTimeInSeconds(payload.getPrepTimeInSeconds());
            recipe.setTotalTime(payload.getTotalTime());
            recipe.setTotalTimeInSeconds(payload.getTotalTimeInSeconds());
            recipe.setRating(payload.getRating());
            recipe.setIngredientLines(payload.getIngredientLines());
            recipe.setFlavors(payload.getFlavors());
            recipe.setImages(payload.getImages());
            recipe.setNutritionEstimates(payload.getNutritionEstimates());

        }
        return recipe;
    }

    /**
     * Transform a List of {@link RecipeDetailPayload} into a Collection of {@link RecipeDetailModel}.
     *
     * @param recipeDetailPayload Object Collection to be transformed.
     * @return {@link RecipeDetailModel} if valid {@link RecipeDetailPayload} otherwise null.
     */
    public static List<RecipeDetailModel> transform(Collection<RecipeDetailPayload> recipeDetailPayload) throws NoSuchFieldException, IllegalAccessException {
        List<RecipeDetailModel> recipeList = new ArrayList<>(20);
        RecipeDetailModel Recipe;
        for (RecipeDetailPayload RecipePayload : recipeDetailPayload) {
            Recipe = transform(RecipePayload);
            if (Recipe != null) {
                recipeList.add(Recipe);
            }
        }
        return recipeList;
    }
}

