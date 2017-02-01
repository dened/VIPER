package com.example.denischuvasov.viper.domain.order;

import com.example.denischuvasov.viper.api.dto.OrderContainer;
import com.example.denischuvasov.viper.api.dto.OrderData;
import com.example.denischuvasov.viper.api.responses.BaseResponse;

import java.util.Map;

import rx.Observable;

/**
 * Created by denischuvasov on 19.01.17.
 */

public interface OrderRepository {
    Observable<BaseResponse<OrderData>> orders(Map<String, String> queries);
    Observable<BaseResponse<OrderContainer>> order(int id);
}
