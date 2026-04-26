package com.hotel.common.notification;

import com.hotel.common.interfaces.NotificationSender;

public class EmailNotification implements NotificationSender {

    private String email;
    private String subject;
    private String message;

    public EmailNotification(String email, String subject, String message) {
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("Sending EMAIL to: " + recipient + " | Subject: " + subject + " | Message: " + message);
    }
}
