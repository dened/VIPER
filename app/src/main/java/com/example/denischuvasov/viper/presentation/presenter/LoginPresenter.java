package com.example.denischuvasov.viper.presentation.presenter;

import com.example.denischuvasov.viper.api.core.ServiceCreatorUtil;
import com.example.denischuvasov.viper.api.dto.Token;
import com.example.denischuvasov.viper.api.requests.LoginRequest;
import com.example.denischuvasov.viper.api.responses.BaseResponse;
import com.example.denischuvasov.viper.domain.auth.LoginInteractor;
import com.example.denischuvasov.viper.presentation.view.LoginView;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.denischuvasov.viper.ui.activities.AuthActivity;
import com.example.denischuvasov.viper.utils.PreferenceUtils;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;
import rx.Subscriber;

@InjectViewState
public class LoginPresenter extends MvpPresenter<LoginView> {
    Router router;

    LoginInteractor loginInteractor;

    PreferenceUtils preferenceUtils;

//    public LoginPresenter() {
//        App.app().getComponent().inject(this);
//    }

    @Inject
    public LoginPresenter(Router router, LoginInteractor loginInteractor, PreferenceUtils preferenceUtils) {
        this.router = router;
        this.loginInteractor = loginInteractor;
        this.preferenceUtils = preferenceUtils;
    }

    public void login(String email, String password) {
        getViewState().showProgress();
        loginInteractor.execute(new LoginRequest(email, password),
                new Subscriber<BaseResponse<Token>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getViewState().hideProgress();
                        getViewState().showError(e.getMessage());
                    }

                    @Override
                    public void onNext(BaseResponse<Token> tokenBaseResponse) {
                        Token token = tokenBaseResponse.getData();
                        preferenceUtils.putToken(token.getToken());
                        ServiceCreatorUtil.recreate();
                        getViewState().hideProgress();
                        router.backTo(AuthActivity.MAIN_SCREEN);

                    }
                });

    }
}
