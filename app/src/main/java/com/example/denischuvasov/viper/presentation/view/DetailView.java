package com.example.denischuvasov.viper.presentation.view;

import com.arellomobile.mvp.MvpView;
import com.example.denischuvasov.viper.api.dto.OrderContainer;

public interface DetailView extends MvpView {
    void showError(String message);
    void showOrder(OrderContainer orderContainer);
    void showProgress();
    void hideProgress();
}
