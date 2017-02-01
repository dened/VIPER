package com.example.denischuvasov.viper.api.dto;

import java.text.NumberFormat;
import java.util.Locale;


public class ExpressTender {
    private double cost;
    private int numberOfBidders;

    public double getCostValue() {
        return cost;
    }

    public String getCost() {
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("ru","RU"));
        return format.format(cost);
    }

    public int getNumberOfBidders() {
        return numberOfBidders;
    }
}
