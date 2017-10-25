package com.rowland.cheffaue.domain.mapper;

import com.rowland.cheffaue.domain.model.RecipeModel;
import com.rowland.cheffaue.domain.payload.RecipePayload;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Mapper class used to transform {@link RecipePayload} (in the data layer) to {@link RecipeModel} in the
 * domain layer.
 * <p>
 * Created by Rowland on 10/25/2017.
 */

public class RecipePayloadToModelMapper {

    /**
     * Transform a {@link RecipePayload} into an {@link RecipeModel}.
     *
     * @param payload Object to be transformed.
     * @return {@link RecipeModel} if valid {@link RecipePayload} otherwise null.
     */
    public static RecipeModel transform(RecipePayload payload) {
        RecipeModel recipe = null;
        if (payload != null) {
            recipe = new RecipeModel();
            recipe.setId(payload.getId());
            recipe.setRecipeName(payload.getRecipeName());
            recipe.setSourceDisplayName(payload.getSourceDisplayName());
            recipe.setRating(payload.getRating());
            recipe.setTotalTimeInSeconds(payload.getTotalTimeInSeconds());
            recipe.setFlavors(payload.getFlavors());
            recipe.setIngredients(payload.getIngredients());
            recipe.setImageUrlsBySize(payload.getImageUrlsBySize());
        }
        return recipe;
    }

    /**
     * Transform a List of {@link RecipePayload} into a Collection of {@link RecipeModel}.
     *
     * @param RecipePayloadCollection Object Collection to be transformed.
     * @return {@link RecipeModel} if valid {@link RecipePayload} otherwise null.
     */
    public static List<RecipeModel> transform(Collection<RecipePayload> RecipePayloadCollection) {
        List<RecipeModel> RecipeList = new ArrayList<>(20);
        RecipeModel Recipe;
        for (RecipePayload RecipePayload : RecipePayloadCollection) {
            Recipe = transform(RecipePayload);
            if (Recipe != null) {
                RecipeList.add(Recipe);
            }
        }
        return RecipeList;
    }
}

