package com.example.denischuvasov.viper.api.core;

import com.example.denischuvasov.viper.api.dto.OrderContainer;
import com.example.denischuvasov.viper.api.dto.OrderData;
import com.example.denischuvasov.viper.api.responses.BaseResponse;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by denischuvasov on 19.01.17.
 */

public interface OrderService {
    @GET("api/v1/order")
    Observable<BaseResponse<OrderData>> orders(@QueryMap Map<String, String> queries);

    @GET("api/v1/order/{id}")
    Observable<BaseResponse<OrderContainer>> order(@Path("id") int id);
}
