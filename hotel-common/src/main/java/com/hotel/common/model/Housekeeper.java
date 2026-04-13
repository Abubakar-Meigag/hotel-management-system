package com.hotel.common.model;

public class Housekeeper extends Account{

    private String housekeeperId;

    public Housekeeper(String name, String email, String phone, String username, String passwordHash, String status, String housekeeperId) {
        super(name, email, phone, username, passwordHash, status);
        this.housekeeperId = housekeeperId;
    }

    public String getHousekeeperId() {
        return housekeeperId;
    }

    public void setHousekeeperId(String housekeeperId) {
        this.housekeeperId = housekeeperId;
    }
}
