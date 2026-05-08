package com.hotel.notification.service;

import com.hotel.common.interfaces.NotificationSender;
import com.hotel.common.notification.EmailNotification;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private NotificationSender sender = new EmailNotification("", "", "");

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
