package com.rowland.cheffaue.restfeature.interceptors;

import java.io.IOException;

import okhttp3.Interceptor;

/**
 * Created by Rowland on 10/25/2017.
 */

public class ResponseCacheInterceptor implements Interceptor {

    // Cach data for one minute
    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        okhttp3.Response originalResponse = chain.proceed(chain.request());

        String cacheControl = originalResponse.header("Cache-Control");
        if (cacheControl == null || cacheControl.contains("no-store") || cacheControl.contains("no-cache") ||
                cacheControl.contains("must-revalidate") || cacheControl.contains("max-age=0")) {
            return originalResponse.newBuilder()
                    .header("Cache-Control", "public, max-age=" + 60)
                    .build();
        } else {
            return originalResponse;
        }
    }
}
