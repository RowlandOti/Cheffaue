package com.rowland.cheffaue.collectionfeature.contracts;

import com.rowland.cheffaue.presenter.IPresenter;
import com.rowland.cheffaue.view.IView;

import java.util.Collection;

/**
 * Created by Rowland on 10/24/2017.
 */

public interface IRecipeCollectionContract {

    interface IRecipeCollectionView<E> extends IView {
        void renderRecipeCollection(Collection<E> Collection);

        void viewRecipe(E model);

        void loadRecipeCollection();
    }

    interface IRecipeCollectionPresenter<E> extends IPresenter {
        void loadRecipeCollection();

        void viewRecipe(E model);
    }
}
