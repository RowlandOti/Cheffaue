package com.rowland.cheffaue.detailfeature.contracts;

import com.rowland.cheffaue.presenter.IPresenter;
import com.rowland.cheffaue.view.IView;

import java.util.Collection;

/**
 * Created by Rowland on 10/24/2017.
 */

public interface IRecipeDetailContract {

    interface IRecipeDetailView<E> extends IView {

        void renderRecipeDetail(E model);

        void loadRecipeDetail(E model);
    }

    interface IRecipeDetailPresenter<E> extends IPresenter {

        void loadRecipeDetail(E model);
    }
}
