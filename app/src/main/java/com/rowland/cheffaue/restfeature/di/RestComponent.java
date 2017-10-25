package com.rowland.cheffaue.restfeature.di;

import android.content.Context;

import com.rowland.cheffaue.appfeature.di.ApplicationComponent;
import com.rowland.cheffaue.appfeature.di.ApplicationModule;
import com.rowland.cheffaue.restfeature.RestScope;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Subcomponent;
import retrofit2.Retrofit;

/**
 * Created by Rowland on 10/25/2017.
 */

@RestScope
@Subcomponent(modules = {RestModule.class})
public interface RestComponent {
    Retrofit retrofit();
}
