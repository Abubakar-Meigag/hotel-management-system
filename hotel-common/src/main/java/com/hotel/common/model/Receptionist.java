package com.hotel.common.model;

public class Receptionist extends Account {

    private String employeeId;

    public Receptionist(String name, String email, String phone, String username, String passwordHash, String status, String employeeId) {
        super(name, email, phone, username, passwordHash, status);
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
