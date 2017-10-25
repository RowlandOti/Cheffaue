/*
 * Copyright 2015 Oti Rowland
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.rowland.cheffaue.restfeature.interceptors;

import com.rowland.cheffaue.BuildConfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Oti Rowland on 12/23/2015.
 */
public class SessionRequestInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        // Get a Request object
        Request request = chain.request();
        // Add headers to the Request object
        request = request.newBuilder()
                .addHeader("User-Agent", BuildConfig.APPLICATION_ID)
                .addHeader("Version", BuildConfig.VERSION_NAME)
                .addHeader("Flavour", BuildConfig.FLAVOR)
                .addHeader("X-Yummly-App-ID", BuildConfig.APP_ID)
                .addHeader("X-Yummly-App-Key", BuildConfig.API_KEY)
                .build();
        Response response = chain.proceed(request);
        // Return response
        return response;
    }
}