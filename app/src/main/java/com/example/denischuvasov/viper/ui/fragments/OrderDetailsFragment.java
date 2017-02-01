package com.example.denischuvasov.viper.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.denischuvasov.viper.R;
import com.example.denischuvasov.viper.api.dto.OrderContainer;
import com.example.denischuvasov.viper.presentation.presenter.DetailPresenter;
import com.example.denischuvasov.viper.presentation.view.DetailView;
import com.example.denischuvasov.viper.ui.common.BaseFragment;
import com.example.denischuvasov.viper.ui.views.OrderView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by denischuvasov on 23.01.17.
 */
public class OrderDetailsFragment extends BaseFragment implements DetailView {
    private static final String KEY_ORDER_ID = "ORDER_ID";

    @BindView(R.id.order)
    OrderView orderView;

    @BindView(R.id.progressbar)
    View progressbarView;

    @InjectPresenter
    DetailPresenter detailPresenter;

    @ProvidePresenter
    DetailPresenter provideDetailPresenter() {
        int orderId = getArguments().getInt(KEY_ORDER_ID);
        return new DetailPresenter(orderId);
    }

    public static OrderDetailsFragment newInstance(int orderId) {
        Bundle args = new Bundle();
        args.putInt(KEY_ORDER_ID, orderId);
        OrderDetailsFragment fragment = new OrderDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order_details, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void showError(String message) {
        Snackbar.make(getView(), message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showOrder(OrderContainer orderContainer) {
        orderView.setOrder(orderContainer.getOrder());
    }

    @Override
    public void showProgress() {
        progressbarView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressbarView.setVisibility(View.GONE);
    }
}
