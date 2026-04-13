package com.hotel.common.model;

public class Manager extends Account {

    private String managerId;

    public Manager(String name, String email, String phone, String username, String passwordHash, String status, String managerId) {
        super(name, email, phone, username, passwordHash, status);
        this.managerId = managerId;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }
}
