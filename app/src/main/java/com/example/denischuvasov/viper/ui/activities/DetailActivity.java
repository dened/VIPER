package com.example.denischuvasov.viper.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;


import com.example.denischuvasov.viper.R;

import com.example.denischuvasov.viper.ui.common.BaseActivity;
import com.example.denischuvasov.viper.ui.fragments.OrderDetailsFragment;

public class DetailActivity extends BaseActivity {
    public static final String TAG = "DetailActivity";
    private static final String KEY_ORDER_ID = "ORDER_ID";

    public static Intent getIntent(final Context context, int orderId) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(KEY_ORDER_ID, orderId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if(savedInstanceState == null) {
            int orderId = getIntent().getIntExtra(KEY_ORDER_ID, -1);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.rootContent, OrderDetailsFragment.newInstance(orderId))
                    .commit();
        }
    }
}
