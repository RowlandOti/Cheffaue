package com.rowland.cheffaue.appfeature.di;

import android.content.Context;

import com.rowland.cheffaue.collectionfeature.di.RecipeCollectionComponent;
import com.rowland.cheffaue.collectionfeature.di.RecipeCollectionModule;
import com.rowland.cheffaue.restfeature.di.RestComponent;
import com.rowland.cheffaue.restfeature.di.RestModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Rowland on 10/24/2017.
 */

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    Context context();
    RestComponent restComponent(RestModule restModule);
    RecipeCollectionComponent recipeCollectionComponent(RecipeCollectionModule recipeMod);
}
