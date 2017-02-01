package com.example.denischuvasov.viper.api.dto;

import java.io.Serializable;


public class CompanyInfo implements Serializable {
    private String shortName;
    private String actualAddress;
    private String cityPhone;
    private String phone;
    private String legalName;
    private String headName;
    private String legalAddress;
    private String inn;
    private String orgn;
    private int isWithVAT;


    public String getShortName() {
        return shortName;
    }

    public String getActualAddress() {
        return actualAddress;
    }

    public CompanyInfo setActualAddress(String actualAddress) {
        this.actualAddress = actualAddress;
        return this;
    }

    public String getCityPhone() {
        return cityPhone;
    }

    public String getPhone() {
        return phone;
    }

    public CompanyInfo setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getLegalName() {
        return legalName;
    }

    public String getHeadName() {
        return headName;
    }

    public String getLegalAddress() {
        return legalAddress;
    }

    public String getInn() {
        return inn;
    }

    public String getOrgn() {
        return orgn;
    }

    public boolean isWithVAT() {
        return isWithVAT == 1;
    }

    public CompanyInfo setWithVAT(boolean withVAT) {
        isWithVAT = withVAT ? 1 : 0;
        return this;
    }
}
