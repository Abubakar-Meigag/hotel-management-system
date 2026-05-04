package com.hotel.booking.event;


import com.hotel.common.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class CheckoutEventPublisher {

    private RabbitTemplate rabbitTemplate;

    public CheckoutEventPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    public void publishCheckoutEvent(Long bookingId){
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.CHECKOUT_EXCHANGE,
                RabbitMQConfig.CHECKOUT_ROUTING_KEY,
                bookingId
        );
    }

}
