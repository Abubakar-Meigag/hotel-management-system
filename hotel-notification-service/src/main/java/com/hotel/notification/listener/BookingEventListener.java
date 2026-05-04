package com.hotel.notification.listener;


import com.hotel.common.config.RabbitMQConfig;
import com.hotel.notification.service.NotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class BookingEventListener {

    private NotificationService notificationService;

    public BookingEventListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RabbitListener(queues = RabbitMQConfig.BOOKING_CONFIRMED_QUEUE)
    public void handleBookingConfirmed(Long bookingId) {
        notificationService.sendBookingConfirmation("guest@email.com");
    }

    @RabbitListener(queues = RabbitMQConfig.BOOKING_CANCELLED_QUEUE)
    public void handleBookingCancelled(Long bookingId) {
        notificationService.sendBookingCancellation("guest@email.com");
    }

    @RabbitListener(queues = RabbitMQConfig.CHECKOUT_QUEUE)
    public void handleCheckout(Long bookingId) {
        notificationService.sendCheckInReminder("guest@email.com");
    }
}
