package com.example.denischuvasov.viper.presentation.presenter;


import com.example.denischuvasov.viper.App;
import com.example.denischuvasov.viper.api.dto.Order;
import com.example.denischuvasov.viper.api.dto.OrderData;
import com.example.denischuvasov.viper.api.responses.BaseResponse;
import com.example.denischuvasov.viper.domain.order.OrdersInteractor;
import com.example.denischuvasov.viper.presentation.view.OrderListView;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import rx.Subscriber;

@InjectViewState
public class OrderListPresenter extends MvpPresenter<OrderListView> {
    private static final int FIRST_PAGE = 1;
    @Inject
    OrdersInteractor ordersInteractor;

    private boolean mIsInLoading;
    public static final int PAGE_LIMIT = 20;

    public OrderListPresenter() {
        App.app().getComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        loadOrders(false);
    }

    public void loadNextOrders(int currentCount) {
        int page = currentCount / PAGE_LIMIT + 1;

        loadData(page, true, false);
    }

    private void loadOrders(boolean isRefreshing) {
        loadData(FIRST_PAGE, false, isRefreshing);
    }

    private void loadData(int page, final boolean isPageLoading, final boolean isRefreshing) {
        if(mIsInLoading)
            return;
        mIsInLoading = true;

        showProgress(isPageLoading, isRefreshing);

        Map<String, String> map = new HashMap<>();
        map.put("page", String.valueOf(page));
        map.put("limit", String.valueOf(PAGE_LIMIT));
        ordersInteractor.execute(map, new Subscriber<BaseResponse<OrderData>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                onLoadingFinish(isPageLoading, isRefreshing);
                onLoadingFailed(e);
            }

            @Override
            public void onNext(BaseResponse<OrderData> orderDataBaseResponse) {
                onLoadingFinish(isPageLoading, isRefreshing);
                onLoadingSuccess(isPageLoading, orderDataBaseResponse.getData());
            }
        });
    }

    private void onLoadingSuccess(boolean isPageLoading, OrderData orderData) {
        List<Order> orders = orderData.getOrder();
        boolean maybeMore = orderData.getTotal() > orders.size();
        if (isPageLoading) {
            getViewState().addOrders(orders, maybeMore);
        } else {
            getViewState().setOrders(orders, maybeMore);
        }
    }

    private void onLoadingFinish(boolean isPageLoading, boolean isRefreshing) {
        mIsInLoading = false;

        hideProgress(isPageLoading, isRefreshing);
    }

    private void hideProgress(boolean isPageLoading, boolean isRefreshing) {
        if (isPageLoading) {
            return;
        }

        if (isRefreshing) {
            getViewState().hideRefreshing();
        }
    }

    private void onLoadingFailed(Throwable error) {
        getViewState().showError(error.toString());
    }

    private void showProgress(boolean isPageLoading, boolean isRefreshing) {
        if (isPageLoading) {
            return;
        }

        if (isRefreshing) {
            getViewState().showRefreshing();
        }
    }
}
