package com.hotel.common.model;

public abstract class Account extends Person {

    private String username;
    private String passwordHash;
    private String status;

    public Account(String name, String email, String phone, String username, String passwordHash, String status) {
        super(name, email, phone);
        this.username = username;
        this.passwordHash = passwordHash;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
