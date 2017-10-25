package com.rowland.cheffaue.collectionfeature.presenter;


import android.app.Fragment;

import com.rowland.cheffaue.domain.mapper.RecipePayloadToModelMapper;
import com.rowland.cheffaue.domain.payload.RecipeListPayload;
import com.rowland.cheffaue.domain.payload.RecipePayload;
import com.rowland.cheffaue.collectionfeature.contracts.IRecipeCollectionContract;
import com.rowland.cheffaue.restfeature.RecipeService;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Rowland on 10/24/2017.
 */

public class RecipeCollectionPresenter implements IRecipeCollectionContract.IRecipeCollectionPresenter {

    Retrofit mRetrofit;
    IRecipeCollectionContract.IRecipeCollectionView mView;

    @Inject
    public RecipeCollectionPresenter(IRecipeCollectionContract.IRecipeCollectionView mView) {
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

    }

    @Override
    public void loadRecipeCollection() {
        mRetrofit.create(RecipeService.class)
                .getRecipeList("soup")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new RecipeListSubscriber());
    }

    private final class RecipeListSubscriber extends rx.Subscriber<RecipeListPayload> {

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
