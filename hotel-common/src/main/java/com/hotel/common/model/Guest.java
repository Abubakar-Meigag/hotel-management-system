package com.hotel.common.model;

public class Guest extends Account {

    private String guestName;
    private String guestPhone;
    private String guestEmail;

    public Guest(String name, String email, String phone, String username, String passwordHash, String status, String guestName, String guestPhone, String guestEmail) {
        super(name, email, phone, username, passwordHash, status);
        this.guestName = guestName;
        this.guestPhone = guestPhone;
        this.guestEmail = guestEmail;
    }


    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestPhone() {
        return guestPhone;
    }

    public void setGuestPhone(String guestPhone) {
        this.guestPhone = guestPhone;
    }

    public String getGuestEmail() {
        return guestEmail;
    }

    public void setGuestEmail(String guestEmail) {
        this.guestEmail = guestEmail;
    }
}
