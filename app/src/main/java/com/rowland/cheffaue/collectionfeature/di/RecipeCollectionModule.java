package com.rowland.cheffaue.collectionfeature.di;

import com.rowland.cheffaue.collectionfeature.contracts.IRecipeCollectionContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rowland on 10/25/2017.
 */

@Module
public class RecipeCollectionModule {

    private IRecipeCollectionContract.IRecipeCollectionView mRecipeView;

    public RecipeCollectionModule(IRecipeCollectionContract.IRecipeCollectionView view) {
        this.mRecipeView = view;
    }

    @RecipeCollectionScope
    @Provides
    IRecipeCollectionContract.IRecipeCollectionView provideRecipeCollectionView() {
        return mRecipeView;
    }
}
