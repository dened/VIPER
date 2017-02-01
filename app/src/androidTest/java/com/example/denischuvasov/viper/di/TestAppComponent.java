package com.example.denischuvasov.viper.di;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by denischuvasov on 25.01.17.
 */

@Singleton
@Component(modules = {AppModule.class, TestDomainModule.class, DataModule.class, NavigationModule.class})
public interface TestAppComponent extends AppComponent{
}
