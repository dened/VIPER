package com.example.denischuvasov.viper.presentation.presenter;

import com.example.denischuvasov.viper.api.requests.LoginRequest;
import com.example.denischuvasov.viper.domain.auth.LoginInteractor;
import com.example.denischuvasov.viper.presentation.view.LoginView;
import com.example.denischuvasov.viper.presentation.view.LoginView$$State;
import com.example.denischuvasov.viper.utils.PreferenceUtils;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import ru.terrakok.cicerone.Router;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.plugins.RxJavaPlugins;
import rx.plugins.RxJavaSchedulersHook;
import rx.schedulers.Schedulers;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

/**
 * Created by denischuvasov on 24.01.17.
 */

public class LoginPresenterTest {
    @Mock
    Router router;

    @Mock
    LoginInteractor loginInteractor;

    @Mock
    PreferenceUtils preferenceUtils;

    @Mock
    LoginView loginView;

    @Mock
    LoginView$$State loginView$$State;

    LoginPresenter loginPresenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        loginPresenter = new LoginPresenter(router, loginInteractor, preferenceUtils);
        loginPresenter.attachView(loginView);
        loginPresenter.setViewState(loginView$$State);
        RxJavaPlugins.getInstance().reset();
        RxJavaPlugins.getInstance().registerSchedulersHook(new RxJavaSchedulersHook(){
            @Override
            public Scheduler getIOScheduler() {
                return Schedulers.immediate();
            }
        });

        RxAndroidPlugins.getInstance().reset();
        RxAndroidPlugins.getInstance().registerSchedulersHook(new RxAndroidSchedulersHook() {
            @Override
            public Scheduler getMainThreadScheduler() {
                return Schedulers.immediate();
            }
        });

    }

    @Test
    public void verify_login() throws Exception {
        loginPresenter.login("ss@ss.mail.ru", "safasdfsa");
        verify(loginView$$State).showProgress();
        verify(loginInteractor).execute(any(LoginRequest.class), any(Subscriber.class));
    }
}
