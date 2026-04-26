package com.hotel.common.notification;

import com.hotel.common.interfaces.NotificationSender;

public class SMSNotification implements NotificationSender {

    private String phoneNumber;
    private String message;

    public SMSNotification(String phoneNumber, String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("Sending notification to " + recipient + ": " + message);
    }
}
