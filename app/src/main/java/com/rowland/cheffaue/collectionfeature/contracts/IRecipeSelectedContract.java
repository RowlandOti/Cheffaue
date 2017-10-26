package com.rowland.cheffaue.collectionfeature.contracts;

import com.rowland.cheffaue.domain.model.RecipeModel;

/**
 * Created by Rowland on 10/26/2017.
 */

public interface IRecipeSelectedContract {

    interface onClickListener {
        void onItemClick(RecipeModel model);
    }

    interface onLongClickListener {
        void onItemLongClick(RecipeModel model);
    }
}
