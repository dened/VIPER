package com.example.denischuvasov.viper.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.denischuvasov.viper.App;
import com.example.denischuvasov.viper.R;
import com.example.denischuvasov.viper.ui.common.BaseFragment;
import com.example.denischuvasov.viper.presentation.view.StartView;
import com.example.denischuvasov.viper.presentation.presenter.StartPresenter;

import com.arellomobile.mvp.presenter.InjectPresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.terrakok.cicerone.Router;

public class StartPageFragment extends BaseFragment implements StartView {
    public static final String TAG = "StartPageFragment";
    @Inject
    Router router;

    @InjectPresenter
    StartPresenter startPresenter;

    @ProvidePresenter
    public StartPresenter createStartPresenter() {
        return new StartPresenter(router);
    }

    public static StartPageFragment newInstance() {
        StartPageFragment fragment = new StartPageFragment();

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
        View view = inflater.inflate(R.layout.fragment_start_page, container, false);
        ButterKnife.bind(this, view);
        view.findViewById(R.id.button_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSignInButtonClick(v);
            }
        });
        return view;
    }

    @OnClick(R.id.button_register)
    void onRegisterButtonClick(View view) {
        startPresenter.onSignUpClick();
    }

    @OnClick(R.id.button_login)
    void onSignInButtonClick(View view) {
        startPresenter.onSignInClick();
    }
}
