package com.example.denischuvasov.viper.api.core;

import android.text.TextUtils;

import com.example.denischuvasov.viper.App;
import com.example.denischuvasov.viper.utils.PreferenceUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by denischuvasov on 18.01.17.
 */

public final class ApiKeyInterceptor implements Interceptor {
    private static final String AUTHORIZATION = "Authorization";
    PreferenceUtils preferenceUtils;


    public ApiKeyInterceptor() {
        this.preferenceUtils = new PreferenceUtils(App.app());
    }

    public static Interceptor create() {
        return new ApiKeyInterceptor();
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        String token = preferenceUtils.getToken();
        if(TextUtils.isEmpty(token)) {
            return chain.proceed(chain.request());
        }
        Request request = chain.request().newBuilder()
                .addHeader(AUTHORIZATION, token)
                .build();
        return chain.proceed(request);
    }
}
