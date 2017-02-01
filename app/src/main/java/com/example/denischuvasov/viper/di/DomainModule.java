package com.example.denischuvasov.viper.di;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by denischuvasov on 18.01.17.
 */

@Module
public class DomainModule {
    public static final String JOB = "job";
    public static final String UI = "ui";

    @Provides
    @Singleton
    @Named(JOB)
    public Scheduler provideJobScheduler() {
        return Schedulers.computation();
    }

    @Provides
    @Singleton
    @Named(UI)
    public Scheduler providerUIScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
