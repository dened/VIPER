package com.example.denischuvasov.viper.api.dto;

/**
 * Created by denischuvasov on 16.01.17.
 */

public class Token {
    private String token;

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "Token{" +
                "token='" + token + '\'' +
                '}';
    }
}
