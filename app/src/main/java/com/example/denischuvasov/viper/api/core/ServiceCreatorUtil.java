package com.example.denischuvasov.viper.api.core;

import android.support.annotation.NonNull;

import com.example.denischuvasov.viper.BuildConfig;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by denischuvasov on 16.01.17.
 */

public class ServiceCreatorUtil {
    private static OkHttpClient okHttpClient;
    private static Retrofit retrofit;

    private ServiceCreatorUtil() {
        throw new IllegalAccessError("Utility class");
    }


    public static <S> S createService(Class<S> serviceClass) {
        return getRetrofit().create(serviceClass);
    }

    @NonNull
    private static Retrofit buildRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.API_ENDPOINT)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }


    @NonNull
    private static OkHttpClient buildClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(LoggingInterceptor.create())
                .addInterceptor(ApiKeyInterceptor.create())
                .build();
    }

    public static void recreate() {
        okHttpClient = null;
        okHttpClient = getClient();
        retrofit = null;
        retrofit = buildRetrofit();
    }

    @NonNull
    private static OkHttpClient getClient() {
        OkHttpClient client = okHttpClient;
        if (client == null) {
            synchronized (ServiceCreatorUtil.class) {
                client = okHttpClient;
                if (client == null) {
                    client = okHttpClient = buildClient();
                }
            }
        }
        return client;
    }

    @NonNull
    private static Retrofit getRetrofit() {
        Retrofit r = retrofit;
        if (r == null) {
            synchronized (ServiceCreatorUtil.class) {
                r = retrofit;
                if (r == null) {
                    r = retrofit = buildRetrofit();
                }
            }
        }
        return r;
    }
}
