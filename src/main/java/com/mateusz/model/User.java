package com.mateusz.model;

public class User {

    public final static String PRODUCT_SEPARATOR = "#";

    private int id;
    private String login;
    private String password;

    public User(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return id + PRODUCT_SEPARATOR +
                login + PRODUCT_SEPARATOR +
                password;
    }
}
