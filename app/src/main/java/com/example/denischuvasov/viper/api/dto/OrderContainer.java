package com.example.denischuvasov.viper.api.dto;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class OrderContainer {
    private Order order;
    private ClientInfo client;
    @SerializedName("contact")
    private List<Contact> contacts;
    private String serverDate;

    public Order getOrder() {
        return order;
    }

    public ClientInfo getClient() {
        return client;
    }

    public List<Contact> getContacts() {
        return contacts;
    }



}
