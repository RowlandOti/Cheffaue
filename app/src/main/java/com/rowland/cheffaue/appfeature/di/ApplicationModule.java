package com.rowland.cheffaue.appfeature.di;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rowland on 10/25/2017.
 */

@Module
public class ApplicationModule {

    Context mContext;

    public ApplicationModule(@NonNull Context context) {
        this.mContext = context;
    }

    @Singleton
    @Provides
    Context provideContext() {
        return mContext;
    }
}
