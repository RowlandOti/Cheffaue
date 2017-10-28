package com.rowland.cheffaue.appfeature;

import android.app.Application;

import com.rowland.cheffaue.appfeature.di.ApplicationComponent;
import com.rowland.cheffaue.appfeature.di.ApplicationModule;
import com.rowland.cheffaue.appfeature.di.DaggerApplicationComponent;
import com.rowland.cheffaue.collectionfeature.contracts.IRecipeCollectionContract;
import com.rowland.cheffaue.collectionfeature.di.RecipeCollectionComponent;
import com.rowland.cheffaue.collectionfeature.di.RecipeCollectionModule;
import com.rowland.cheffaue.detailfeature.contracts.IRecipeDetailContract;
import com.rowland.cheffaue.detailfeature.di.RecipeDetailComponent;
import com.rowland.cheffaue.detailfeature.di.RecipeDetailModule;
import com.rowland.cheffaue.restfeature.di.RestComponent;
import com.rowland.cheffaue.restfeature.di.RestModule;

/**
 * Android Main Application
 */
public class ApplicationController extends Application {

    private ApplicationComponent appComponent;
    private RestComponent restComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private void initializeInjector() {
        this.appComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        this.restComponent = this.appComponent.restComponent(new RestModule("https://api.yummly.com/v1/api/"));
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        appComponent = null;
        restComponent = null;
    }

    public ApplicationComponent getAppComponent() {
        return this.appComponent;
    }

    public RestComponent getRestComponent() {
        return this.restComponent;
    }

    public RecipeCollectionComponent getRecipeCollectionComponent(IRecipeCollectionContract.IRecipeCollectionView view) {
        return appComponent.recipeCollectionComponent(new RecipeCollectionModule(view));
    }

    public RecipeDetailComponent getRecipeDetailComponent(IRecipeDetailContract.IRecipeDetailView view) {
        return appComponent.recipeDetailComponent(new RecipeDetailModule(view));
    }
}
