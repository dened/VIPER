package com.example.denischuvasov.viper.api.core;

import com.example.denischuvasov.viper.api.dto.Token;
import com.example.denischuvasov.viper.api.requests.LoginRequest;
import com.example.denischuvasov.viper.api.responses.BaseResponse;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by denischuvasov on 16.01.17.
 */

public interface LoginService {
    @POST("api/v1/login")
    Observable<BaseResponse<Token>> login(@Body LoginRequest request);
}
