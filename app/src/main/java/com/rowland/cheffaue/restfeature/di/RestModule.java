package com.rowland.cheffaue.restfeature.di;

import android.app.Application;
import android.content.Context;

import com.google.gson.GsonBuilder;
import com.rowland.cheffaue.BuildConfig;
import com.rowland.cheffaue.restfeature.RestScope;
import com.rowland.cheffaue.restfeature.interceptors.OfflinePersistenceCacheInterceptor;
import com.rowland.cheffaue.restfeature.interceptors.ResponseCacheInterceptor;
import com.rowland.cheffaue.restfeature.interceptors.SessionRequestInterceptor;

import java.io.File;
import java.lang.reflect.Modifier;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rowland on 10/25/2017.
 */

@Module
public class RestModule {

    //private final Application mApplication;
    private String mBaseUrl;

    public RestModule(String baseUrl) {
        //this.mApplication = application;
        this.mBaseUrl = baseUrl;
    }

    @Provides
    @RestScope
    Cache provideHttpCache(Context context) {
        // allocate a 5 MB cache
        return new Cache(context.getCacheDir(), 5 * 1024 * 1024);
    }

    @RestScope
    @Provides
    OkHttpClient provideOkHttpClient(Cache okHttpCacheCache, Context context) {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient().newBuilder();
        okHttpClientBuilder.addNetworkInterceptor(new SessionRequestInterceptor())
                .addNetworkInterceptor(new ResponseCacheInterceptor())
                .addInterceptor(new OfflinePersistenceCacheInterceptor(context))
                .cache(okHttpCacheCache);

        if (BuildConfig.DEBUG) {
            okHttpClientBuilder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        }

        return okHttpClientBuilder.build();
    }

    @RestScope
    @Provides
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd")
                        .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                        .excludeFieldsWithoutExposeAnnotation().create()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }
}
