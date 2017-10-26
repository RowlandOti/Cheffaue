package com.rowland.cheffaue.detailfeature.di;

import com.rowland.cheffaue.detailfeature.contracts.IRecipeDetailContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rowland on 10/26/2017.
 */

@Module
public class RecipeDetailModule {

    private IRecipeDetailContract.IRecipeDetailView mRecipeView;

    public RecipeDetailModule(IRecipeDetailContract.IRecipeDetailView view) {
        this.mRecipeView = view;
    }

    @RecipeDetailScope
    @Provides
    IRecipeDetailContract.IRecipeDetailView provideRecipeDetailView() {
        return this.mRecipeView;
    }
}
