package com.rowland.cheffaue.collectionfeature.di;

import com.rowland.cheffaue.detailfeature.view.fragments.RecipeDetailFragment;
import com.rowland.cheffaue.collectionfeature.view.activities.RecipeActivity;
import com.rowland.cheffaue.collectionfeature.view.fragments.RecipeCollectionFragment;
import com.rowland.cheffaue.restfeature.di.RestComponent;
import com.rowland.cheffaue.restfeature.di.RestModule;

import dagger.Subcomponent;

/**
 * Created by Rowland on 10/25/2017.
 */

/**
 * A scope {@link RecipeCollectionScope} component.
 * Injects recipe specific Fragments.
 */
@RecipeCollectionScope
@Subcomponent(modules = {RecipeCollectionModule.class})
public interface RecipeCollectionComponent {

    void inject(RecipeActivity recipeActivity);

    void inject(RecipeCollectionFragment recipeListFragment);
}
