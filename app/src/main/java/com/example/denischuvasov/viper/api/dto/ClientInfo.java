package com.example.denischuvasov.viper.api.dto;

import java.io.Serializable;

public class ClientInfo implements Serializable {
    private int id;
    private int ownerId;
    private int legalStatusId;
    private Float ratingObservance;
    private Float ratingQuality;
    private Float ratingLoading;
    private Float ratingPayment;
    private Float ratingAvgConsignor;
    private Float ratingAvgCarrier;
    private CompanyInfo company;

    public int getId() {
        return id;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public int getLegalStatusId() {
        return legalStatusId;
    }

    public Float getRatingObservance() {
        return ratingObservance;
    }

    public Float getRatingQuality() {
        return ratingQuality;
    }

    public Float getRatingLoading() {
        return ratingLoading;
    }

    public Float getRatingPayment() {
        return ratingPayment;
    }

    public Float getRatingAvgConsignor() {
        return ratingAvgConsignor;
    }

    public Float getRatingAvgCarrier() {
        return ratingAvgCarrier;
    }

    public CompanyInfo getCompany() {
        return company;
    }
}
