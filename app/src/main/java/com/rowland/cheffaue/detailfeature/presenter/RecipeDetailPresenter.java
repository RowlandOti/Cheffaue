package com.rowland.cheffaue.detailfeature.presenter;

import com.rowland.cheffaue.collectionfeature.presenter.RecipeCollectionPresenter;
import com.rowland.cheffaue.detailfeature.contracts.IRecipeDetailContract;
import com.rowland.cheffaue.domain.mapper.RecipeDetailPayloadToModelMapper;
import com.rowland.cheffaue.domain.mapper.RecipePayloadToModelMapper;
import com.rowland.cheffaue.domain.model.RecipeModel;
import com.rowland.cheffaue.domain.payload.RecipeDetailPayload;
import com.rowland.cheffaue.domain.payload.RecipeListPayload;
import com.rowland.cheffaue.domain.payload.RecipePayload;
import com.rowland.cheffaue.presenter.IPresenter;
import com.rowland.cheffaue.restfeature.RecipeService;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Rowland on 10/24/2017.
 */

public class RecipeDetailPresenter implements IRecipeDetailContract.IRecipeDetailPresenter {

    Retrofit mRetrofit;
    IRecipeDetailContract.IRecipeDetailView mView;

    @Inject
    public RecipeDetailPresenter(IRecipeDetailContract.IRecipeDetailView mView) {
        this.mView = mView;
    }

    public void setRetrofit(Retrofit retrofit) {
        this.mRetrofit = retrofit;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        mRetrofit = null;
        mView = null;
    }

    @Override
    public void loadRecipeDetail(String recipeId) {
        mView.hideRetry();
        mView.showLoading();
        mRetrofit.create(RecipeService.class)
                .getRecipe(recipeId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new RecipeDetailPresenter.RecipeDetailSubscriber());
    }

    private final class RecipeDetailSubscriber extends rx.Subscriber<RecipeDetailPayload> {

        @Override
        public void onCompleted() {
            mView.hideLoading();
        }

        @Override
        public void onError(Throwable e) {
            mView.hideLoading();
            mView.showError(e.getMessage());
            mView.showRetry();
        }

        @Override
        public void onNext(RecipeDetailPayload recipePayload) {

                mView.renderRecipeDetail(RecipeDetailPayloadToModelMapper.transform(recipePayload));
        }
    }
}
