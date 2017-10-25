package com.rowland.cheffaue.restfeature;

import com.rowland.cheffaue.domain.payload.RecipeListPayload;
import com.rowland.cheffaue.domain.payload.RecipePayload;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Rowland on 10/24/2017.
 */

public interface RecipeService {

    @GET("recipes")
    Observable<RecipeListPayload> getRecipeList(@Query("q") String query);

    @GET("recipe/{recipe-id}")
    Observable<RecipePayload> getRecipe(@Path("recipe-id") String recipeId);
}
