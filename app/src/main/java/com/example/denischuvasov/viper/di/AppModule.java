package com.example.denischuvasov.viper.di;

import android.content.Context;


import com.example.denischuvasov.viper.utils.PreferenceUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by denischuvasov on 12.01.17.
 */
@Module
public class AppModule {
    Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context providesContext() {
        return context;
    }

    @Provides
    @Singleton
    public PreferenceUtils provideSharedPreferences(Context context) {
        return new PreferenceUtils(context);
    }
}
