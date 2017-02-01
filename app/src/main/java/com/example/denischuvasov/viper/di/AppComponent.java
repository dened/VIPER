package com.example.denischuvasov.viper.di;

import com.example.denischuvasov.viper.api.core.ApiKeyInterceptor;
import com.example.denischuvasov.viper.presentation.presenter.DetailPresenter;
import com.example.denischuvasov.viper.presentation.presenter.LoginPresenter;
import com.example.denischuvasov.viper.presentation.presenter.OrderListPresenter;
import com.example.denischuvasov.viper.ui.activities.AuthActivity;
import com.example.denischuvasov.viper.ui.activities.MainActivity;
import com.example.denischuvasov.viper.ui.fragments.OrderListFragment;
import com.example.denischuvasov.viper.ui.fragments.SignInFragment;
import com.example.denischuvasov.viper.ui.fragments.StartPageFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by denischuvasov on 13.01.17.
 */

@Singleton
@Component(modules = {AppModule.class, DomainModule.class, DataModule.class, NavigationModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);
    void inject(AuthActivity authActivity);
    void inject(ApiKeyInterceptor apiKeyInterceptor);
    void inject(StartPageFragment startPageFragment);
    void inject(SignInFragment signInFragment);
    void inject(OrderListPresenter orderListPresenter);
    void inject(LoginPresenter loginPresenter);
    void inject(DetailPresenter detailPresenter);
    void inject(OrderListFragment orderListFragment);
}
