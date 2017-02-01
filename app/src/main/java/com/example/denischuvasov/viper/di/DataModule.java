package com.example.denischuvasov.viper.di;

import com.example.denischuvasov.viper.data.AuthRepositoryImpl;
import com.example.denischuvasov.viper.data.OrderRepositoryImpl;
import com.example.denischuvasov.viper.domain.auth.AuthRepository;
import com.example.denischuvasov.viper.domain.order.OrderRepository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by denischuvasov on 18.01.17.
 */

@Module
public class DataModule {
    @Provides
    public AuthRepository provideAuthRepository() {
        return new AuthRepositoryImpl();
    }

    @Provides
    public OrderRepository provideOrderRepository() {
        return new OrderRepositoryImpl();
    }
}
