package com.example.denischuvasov.viper.ui.fragments;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.denischuvasov.viper.App;
import com.example.denischuvasov.viper.R;
import com.example.denischuvasov.viper.presentation.presenter.LoginPresenter;
import com.example.denischuvasov.viper.presentation.view.LoginView;
import com.example.denischuvasov.viper.ui.common.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignInFragment extends BaseFragment implements LoginView {
    public static final String TAG = "SignInFragment";

    @BindView(R.id.email)
    EditText emailEditText;

    @BindView(R.id.password)
    EditText passwordEditText;

    @Inject
    LoginPresenter providePresenter;

    @InjectPresenter
    LoginPresenter loginPresenter;

    @ProvidePresenter
    LoginPresenter provideLoginPresenter() {
        return providePresenter;
    }


    public static SignInFragment newInstance() {
        SignInFragment fragment = new SignInFragment();

        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        ((App) getActivity().getApplication()).getComponent().inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String message) {
        Snackbar.make(getView(), message, Snackbar.LENGTH_SHORT).show();
    }

    @OnClick(R.id.button_login)
    void onLoginButtonClick(View view) {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        loginPresenter.login(email, password);
    }
}
