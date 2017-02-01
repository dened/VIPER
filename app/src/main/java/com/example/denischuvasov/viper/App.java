package com.example.denischuvasov.viper;

import android.app.Application;

import com.example.denischuvasov.viper.api.core.ServiceCreatorUtil;
import com.example.denischuvasov.viper.di.AppComponent;
import com.example.denischuvasov.viper.di.AppModule;
import com.example.denischuvasov.viper.di.DaggerAppComponent;


/**
 * Created by denischuvasov on 12.01.17.
 */

public class App extends Application {
    private AppComponent component;
    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        component = buildComponent();
        ServiceCreatorUtil.recreate();
    }

    protected AppComponent buildComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getComponent() {
        return component;
    }

    public static App app() {
        return instance;
    }
}
