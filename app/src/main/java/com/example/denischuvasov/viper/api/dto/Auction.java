package com.example.denischuvasov.viper.api.dto;

import java.text.NumberFormat;
import java.util.Locale;


public class Auction {
    private int rebidMinute;
    private int extensionPeriod;
    private int orderId;
    private double openingBid;
    private double stepBid;
    private int increasePercent;
    private String endDate;

    public int getRebidMinute() {
        return rebidMinute;
    }

    public int getExtensionPeriod() {
        return extensionPeriod;
    }

    public int getOrderId() {
        return orderId;
    }

    public double getOpeningBid() {
        return openingBid;
    }

    public double getStepBid() {
        return stepBid;
    }

    public String getStep() {
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("ru","RU"));
        return format.format(stepBid);
    }

    public int getIncreasePercent() {
        return increasePercent;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getCost() {
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("ru","RU"));
        return format.format(openingBid);
    }

}
