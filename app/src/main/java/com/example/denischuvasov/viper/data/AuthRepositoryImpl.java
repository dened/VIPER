package com.example.denischuvasov.viper.data;

import com.example.denischuvasov.viper.api.core.LoginService;
import com.example.denischuvasov.viper.api.core.ServiceCreatorUtil;
import com.example.denischuvasov.viper.api.dto.Token;
import com.example.denischuvasov.viper.api.requests.LoginRequest;
import com.example.denischuvasov.viper.api.responses.BaseResponse;
import com.example.denischuvasov.viper.domain.auth.AuthRepository;

import rx.Observable;

/**
 * Created by denischuvasov on 18.01.17.
 */

public class AuthRepositoryImpl implements AuthRepository {
    LoginService loginService;
    public AuthRepositoryImpl() {
        loginService = ServiceCreatorUtil.createService(LoginService.class);
    }
    @Override
    public Observable<BaseResponse<Token>> login(LoginRequest request) {
        return loginService.login(request);
    }
}
