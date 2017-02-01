package com.example.denischuvasov.viper.api.dto;

import java.text.NumberFormat;
import java.util.Locale;


public class Bid {
    private int id;
    private int orderId;
    private int bidValue;
    private int delivery;

    public int getId() {
        return id;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getBidValue() {
        return bidValue;
    }

    public int getDelivery() {
        return delivery;
    }

    public String getBid() {
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("ru","RU"));
        return format.format(bidValue);
    }
}
