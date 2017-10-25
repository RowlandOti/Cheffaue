package com.rowland.cheffaue.restfeature.interceptors;

import android.content.Context;

import com.rowland.cheffaue.utils.NetworkUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;

/**
 * Created by Rowland on 10/25/2017.
 */

public class OfflinePersistenceCacheInterceptor implements Interceptor {

    private final Context mContext;

    public OfflinePersistenceCacheInterceptor(Context context) {
        mContext = context;
    }

    // cache data for 4-weeks if no internet access all this while
    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (!NetworkUtils.isOnline(mContext)) {
            request = request.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + 7 * 24 * 60 * 60)
                    .build();
       }
        return chain.proceed(request);
    }
}