package com.example.denischuvasov.viper.presentation.presenter;


import com.example.denischuvasov.viper.presentation.view.StartView;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.denischuvasov.viper.ui.activities.AuthActivity;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class StartPresenter extends MvpPresenter<StartView> {
    private Router router;

    public StartPresenter(Router router) {
        this.router = router;
    }

    public void onSignInClick() {
        router.navigateTo(AuthActivity.SIGN_IN_SCREEN);
    }

    public void onSignUpClick() {
        router.navigateTo(AuthActivity.SIGN_UP_SCREEN);
    }
}
