package com.example.denischuvasov.viper.domain.auth;

import com.example.denischuvasov.viper.api.dto.Token;
import com.example.denischuvasov.viper.api.requests.LoginRequest;
import com.example.denischuvasov.viper.api.responses.BaseResponse;

import rx.Observable;

/**
 * Created by denischuvasov on 18.01.17.
 */

public interface AuthRepository {
    Observable<BaseResponse<Token>> login(LoginRequest request);
}
