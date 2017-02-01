package com.example.denischuvasov.viper.presentation.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.denischuvasov.viper.api.dto.Order;

import java.util.List;

public interface OrderListView extends MvpView {
    void showError(String message);

    void showRefreshing();

    void hideRefreshing();

    void setOrders(List<Order> repositories, boolean maybeMore);

    @StateStrategyType(AddToEndStrategy.class)
    void addOrders(List<Order> repositories, boolean maybeMore);
}
