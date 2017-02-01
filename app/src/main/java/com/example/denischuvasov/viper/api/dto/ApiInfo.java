package com.example.denischuvasov.viper.api.dto;

/**
 * Created by denischuvasov on 16.01.17.
 */
public class ApiInfo {
    private int code;
    private String title;
    private String detail;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
