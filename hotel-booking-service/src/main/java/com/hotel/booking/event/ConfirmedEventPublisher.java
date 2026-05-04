package com.hotel.booking.event;


import com.hotel.common.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class ConfirmedEventPublisher {

    private RabbitTemplate rabbitTemplate;

    public ConfirmedEventPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    public void publishConfirmedEvent(Long bookingId){
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.BOOKING_CONFIRMED_EXCHANGE,
                RabbitMQConfig.BOOKING_CONFIRMED_ROUTING_KEY,
                bookingId
        );
    }


}
