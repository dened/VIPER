package com.example.denischuvasov.viper.api.dto;


import java.io.Serializable;

public class Contact implements Serializable {
    private String lastName;
    private String firstName;
    private String secondName;
    private String position;
    private String email;
    private String phone;

    public Contact setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Contact setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Contact setSecondName(String secondName) {
        this.secondName = secondName;
        return this;
    }

    public Contact setPosition(String position) {
        this.position = position;
        return this;
    }

    public Contact setEmail(String email) {
        this.email = email;
        return this;
    }

    public Contact setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return String.format("%s %s %s", lastName, firstName, secondName);
    }
}
