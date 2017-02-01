package com.example.denischuvasov.viper.di;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.schedulers.Schedulers;

@Module
public class TestDomainModule {
    public static final String JOB = "job";
    public static final String UI = "ui";

    @Provides
    @Singleton
    @Named(JOB)
    public Scheduler provideJobScheduler() {
        return Schedulers.immediate();
    }

    @Provides
    @Singleton
    @Named(UI)
    public Scheduler providerUIScheduler() {
        return Schedulers.immediate();
    }
}
