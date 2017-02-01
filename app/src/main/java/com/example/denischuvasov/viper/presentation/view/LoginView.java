package com.example.denischuvasov.viper.presentation.view;

import com.arellomobile.mvp.MvpView;

public interface LoginView extends MvpView {
    void showProgress();
    void hideProgress();
    void showError(String message);
}
