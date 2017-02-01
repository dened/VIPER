package com.example.denischuvasov.viper.data;

import com.example.denischuvasov.viper.api.core.OrderService;
import com.example.denischuvasov.viper.api.core.ServiceCreatorUtil;
import com.example.denischuvasov.viper.api.dto.OrderContainer;
import com.example.denischuvasov.viper.api.dto.OrderData;
import com.example.denischuvasov.viper.api.responses.BaseResponse;
import com.example.denischuvasov.viper.domain.order.OrderRepository;

import java.util.Map;

import rx.Observable;

/**
 * Created by denischuvasov on 19.01.17.
 */

public class OrderRepositoryImpl implements OrderRepository {
    OrderService orderService;
    public OrderRepositoryImpl() {
        orderService = ServiceCreatorUtil.createService(OrderService.class);
    }

    @Override
    public Observable<BaseResponse<OrderData>> orders(Map<String, String> queries) {
        return orderService.orders(queries);
    }

    @Override
    public Observable<BaseResponse<OrderContainer>> order(int id) {
        return orderService.order(id);
    }
}
