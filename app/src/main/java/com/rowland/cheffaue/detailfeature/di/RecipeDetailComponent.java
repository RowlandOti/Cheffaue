package com.rowland.cheffaue.detailfeature.di;

/**
 * Created by Rowland on 10/26/2017.
 */

import com.rowland.cheffaue.detailfeature.view.activities.RecipeDetailActivity;
import com.rowland.cheffaue.detailfeature.view.fragments.RecipeDetailFragment;
import com.rowland.cheffaue.detailfeature.view.fragments.child.IngredientsFragment;

import dagger.Subcomponent;

/**
 * A scope {@link RecipeDetailScope} component.
 * Injects recipe specific Fragments.
 */
@RecipeDetailScope
@Subcomponent(modules = {RecipeDetailModule.class})
public interface RecipeDetailComponent {

    void inject(RecipeDetailActivity recipeDetailActivity);

    void inject(RecipeDetailFragment recipeDetailFragment);
}
