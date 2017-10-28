package com.rowland.cheffaue.collectionfeature.presenter;


import com.rowland.cheffaue.domain.mapper.RecipePayloadToModelMapper;
import com.rowland.cheffaue.domain.model.RecipeModel;
import com.rowland.cheffaue.domain.payload.RecipeListPayload;
import com.rowland.cheffaue.collectionfeature.contracts.IRecipeCollectionContract;
import com.rowland.cheffaue.restfeature.RecipeService;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Rowland on 10/24/2017.
 */

public class RecipeCollectionPresenter implements IRecipeCollectionContract.IRecipeCollectionPresenter<RecipeModel> {

    Retrofit mRetrofit;
    IRecipeCollectionContract.IRecipeCollectionView mView;
    RecipeCollectionSubscriber recipeCollectionSubscriber;

    @Inject
    public RecipeCollectionPresenter(IRecipeCollectionContract.IRecipeCollectionView mView) {
        this.mView = mView;
        this.recipeCollectionSubscriber = new RecipeCollectionPresenter.RecipeCollectionSubscriber();
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
        recipeCollectionSubscriber.unsubscribe();
    }

    @Override
    public void loadRecipeCollection() {
        mView.hideRetry();
        mView.showLoading();
        mRetrofit.create(RecipeService.class)
                .getRecipeList("soup")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(recipeCollectionSubscriber);
    }

    @Override
    public void viewRecipe(RecipeModel model) {
        mView.viewRecipe(model);
    }

    private final class RecipeCollectionSubscriber extends rx.Subscriber<RecipeListPayload> {

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
        public void onNext(RecipeListPayload recipePayload) {
            mView.renderRecipeCollection(RecipePayloadToModelMapper.transform(recipePayload.getRecipePayloadList()));
        }
    }
}
