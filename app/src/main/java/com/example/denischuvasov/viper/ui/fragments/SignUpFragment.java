package com.example.denischuvasov.viper.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.denischuvasov.viper.R;

import butterknife.ButterKnife;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.denischuvasov.viper.ui.common.BaseFragment;
import com.example.denischuvasov.viper.presentation.presenter.SignUpPresenter;
import com.example.denischuvasov.viper.presentation.view.SignUpView;

public class SignUpFragment extends BaseFragment implements SignUpView {
    public static final String TAG = "SignUpFragment";
    @InjectPresenter
    SignUpPresenter mSignUpPresenter;

    public static SignUpFragment newInstance() {
        SignUpFragment fragment = new SignUpFragment();

        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
