package com.example.denischuvasov.viper.domain.order;

import com.example.denischuvasov.viper.api.dto.OrderData;
import com.example.denischuvasov.viper.api.responses.BaseResponse;
import com.example.denischuvasov.viper.di.DomainModule;
import com.example.denischuvasov.viper.domain.common.Interactor;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by denischuvasov on 19.01.17.
 */

public class OrdersInteractor extends Interactor<BaseResponse<OrderData>, Map<String, String>> {
    private final OrderRepository orderRepository;

    @Inject
    public OrdersInteractor(@Named(DomainModule.JOB) Scheduler jobScheduler,
                            @Named(DomainModule.UI) Scheduler uiScheduler,
                            OrderRepository orderRepository) {
        super(jobScheduler, uiScheduler);
        this.orderRepository = orderRepository;
    }

    @Override
    protected Observable<BaseResponse<OrderData>> buildObservable(Map<String, String> queries) {
        return orderRepository.orders(queries);
    }
}