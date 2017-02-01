package com.example.denischuvasov.viper.domain.order;

import com.example.denischuvasov.viper.api.dto.OrderContainer;
import com.example.denischuvasov.viper.api.responses.BaseResponse;
import com.example.denischuvasov.viper.di.DomainModule;
import com.example.denischuvasov.viper.domain.common.Interactor;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by denischuvasov on 23.01.17.
 */

public class OrderInteractor extends Interactor<BaseResponse<OrderContainer>, Integer> {
    private final OrderRepository orderRepository;

    @Inject
    public OrderInteractor(@Named(DomainModule.JOB) Scheduler jobScheduler,
                            @Named(DomainModule.UI) Scheduler uiScheduler,
                            OrderRepository orderRepository) {
        super(jobScheduler, uiScheduler);
        this.orderRepository = orderRepository;
    }


    @Override
    protected Observable<BaseResponse<OrderContainer>> buildObservable(Integer id) {
        return orderRepository.order(id);
    }
}