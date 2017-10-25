package com.rowland.cheffaue.detailfeature.view;

import com.rowland.cheffaue.detailfeature.contracts.IRecipeDetailContract;
import com.rowland.cheffaue.domain.model.RecipeModel;
import com.rowland.cheffaue.view.IView;

/**
 * Interface representing a View in a model view presenter (MVP) pattern.
 * In this case is used as a view representing recipe details.
 */
public interface IRecipeDetailsView extends IRecipeDetailContract.IRecipeDetailView {
    /**
     * Render a detail in the UI.
     *
     * @param user The {@link RecipeModel} that will be shown.
     */
    void renderRecipe(RecipeModel user);
}
