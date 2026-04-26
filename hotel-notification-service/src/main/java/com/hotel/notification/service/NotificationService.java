package com.hotel.notification.service;

import com.hotel.common.interfaces.NotificationSender;

public class NotificationService {

    private NotificationSender sender;

    public NotificationService(NotificationSender sender) {
        this.sender = sender;
    }

    public void sendBookingConfirmation(String recipient){
        sender.sendNotification(recipient, "Booking Confirmation");
    }

    public void sendBookingCancellation(String recipient){
        sender.sendNotification(recipient, "Booking Cancel");
    }

    public void sendCheckInReminder(String recipient){
        sender.sendNotification(recipient, "Check In Reminder");
    }
}
