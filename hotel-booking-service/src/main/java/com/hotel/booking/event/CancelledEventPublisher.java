package com.hotel.booking.event;


import com.hotel.common.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class CancelledEventPublisher {


    private RabbitTemplate rabbitTemplate;

    public CancelledEventPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishCancelledEvent(Long bookingId){
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.BOOKING_CANCELLED_EXCHANGE,
                RabbitMQConfig.BOOKING_CANCELLED_ROUTING_KEY,
                bookingId
        );
    }
}
