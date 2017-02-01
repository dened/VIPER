package com.example.denischuvasov.viper.api.dto;


import java.util.List;

public class OrderData {
    private List<Order> order;
    private int total;
    private String serverDate;

    public List<Order> getOrder() {
        return order;
    }

    public int getTotal() {
        return total;
    }

    public String getServerDate() {
        return serverDate;
    }
}
