package com.example.denischuvasov.viper.api.core;

import android.support.annotation.NonNull;

import com.example.denischuvasov.viper.BuildConfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by denischuvasov on 16.01.17.
 */
public class LoggingInterceptor implements Interceptor {
    private final Interceptor loggingInterceptor;

    public LoggingInterceptor() {
        //TODO: use dagger
        loggingInterceptor = new HttpLoggingInterceptor().
                setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY :HttpLoggingInterceptor.Level.NONE);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        return loggingInterceptor.intercept(chain);
    }

    @NonNull
    public static Interceptor create() {
        return new LoggingInterceptor();
    }
}
