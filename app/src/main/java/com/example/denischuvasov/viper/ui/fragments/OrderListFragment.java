package com.example.denischuvasov.viper.ui.fragments;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.denischuvasov.viper.App;
import com.example.denischuvasov.viper.R;
import com.example.denischuvasov.viper.api.dto.Order;
import com.example.denischuvasov.viper.presentation.presenter.OrderListPresenter;
import com.example.denischuvasov.viper.presentation.view.OrderListView;
import com.example.denischuvasov.viper.ui.activities.MainActivity;
import com.example.denischuvasov.viper.ui.adapters.OrderAdapter;
import com.example.denischuvasov.viper.ui.common.BaseFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.terrakok.cicerone.Router;

public class OrderListFragment extends BaseFragment implements OrderListView, OrderAdapter.OrderAdapterListener {
    public static final String TAG = "OrderListFragment";
    @InjectPresenter
    OrderListPresenter orderListPresenter;

    @Inject
    Router router;

    @BindView(R.id.list)
    RecyclerView recyclerView;

    OrderAdapter orderAdapter;

    public static OrderListFragment newInstance() {
        OrderListFragment fragment = new OrderListFragment();

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
        View view = inflater.inflate(R.layout.fragment_orders, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        orderAdapter = new OrderAdapter(this);
        recyclerView.setAdapter(orderAdapter);
    }

    @Override
    public void showError(String message) {
        Snackbar.make(getView(), message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showRefreshing() {

    }

    @Override
    public void hideRefreshing() {

    }

    @Override
    public void setOrders(List<Order> orders, boolean maybeMore) {
        orderAdapter.setOrders(orders, maybeMore);
    }

    @Override
    public void addOrders(List<Order> orders, boolean maybeMore) {
        orderAdapter.addOrders(orders, maybeMore);
    }

    @Override
    public void onLoadMore() {
        orderListPresenter.loadNextOrders(orderAdapter.getItemCount());
    }

    @Override
    public void onShowOrder(Order order) {
        router.navigateTo(MainActivity.DETAILS_SCREEN, order.getId());
    }
}
