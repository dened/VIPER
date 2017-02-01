package com.example.denischuvasov.viper.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.denischuvasov.viper.App;
import com.example.denischuvasov.viper.api.dto.OrderContainer;
import com.example.denischuvasov.viper.api.responses.BaseResponse;
import com.example.denischuvasov.viper.domain.order.OrderInteractor;
import com.example.denischuvasov.viper.presentation.view.DetailView;

import javax.inject.Inject;

import rx.Subscriber;


@InjectViewState
public class DetailPresenter extends MvpPresenter<DetailView> {
    @Inject
    OrderInteractor orderInteractor;

    public DetailPresenter(int orderId) {
        App.app().getComponent().inject(this);
        loadOrder(orderId);
    }

    private void loadOrder(int orderId) {
        getViewState().showProgress();
        orderInteractor.execute(orderId, new Subscriber<BaseResponse<OrderContainer>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                getViewState().hideProgress();
                getViewState().showError(e.getMessage());
            }

            @Override
            public void onNext(BaseResponse<OrderContainer> orderContainerBaseResponse) {
                getViewState().hideProgress();
                getViewState().showOrder(orderContainerBaseResponse.getData());
            }
        });
    }

}
