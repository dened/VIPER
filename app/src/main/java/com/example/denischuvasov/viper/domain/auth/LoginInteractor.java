package com.example.denischuvasov.viper.domain.auth;

import com.example.denischuvasov.viper.api.dto.Token;
import com.example.denischuvasov.viper.api.requests.LoginRequest;
import com.example.denischuvasov.viper.api.responses.BaseResponse;
import com.example.denischuvasov.viper.di.DomainModule;
import com.example.denischuvasov.viper.domain.common.Interactor;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by denischuvasov on 16.01.17.
 */

public class LoginInteractor extends Interactor<BaseResponse<Token>, LoginRequest> {

    private final AuthRepository authRepository;

    @Inject
    public LoginInteractor(@Named(DomainModule.JOB) Scheduler jobScheduler,
                           @Named(DomainModule.UI) Scheduler uiScheduler,
                           AuthRepository authRepository) {
        super(jobScheduler, uiScheduler);
        this.authRepository = authRepository;
    }


    @Override
    protected Observable<BaseResponse<Token>> buildObservable(LoginRequest request) {
        return authRepository.login(request);
    }
}
