package com.example.denischuvasov.viper.api.requests;

import com.google.gson.annotations.SerializedName;

/**
 * Created by denischuvasov on 16.01.17.
 */
public class LoginRequest {
    @SerializedName("LoginForm[login]")
    private String login;

    @SerializedName("LoginForm[password]")
    private String password;

    public LoginRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
