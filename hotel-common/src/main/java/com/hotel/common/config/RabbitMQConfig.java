package com.hotel.common.config;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/*
@Configuration — tells Spring this class sets up beans and infrastructure, not business logic.
@Bean — tells Spring to manage this object. Spring creates it once and shares it wherever it is needed.
*/

@Configuration
public class RabbitMQConfig {

    public static final String CHECKOUT_QUEUE       = "checkout.queue";
    public static final String CHECKOUT_EXCHANGE    = "checkout.exchange";
    public static final String CHECKOUT_ROUTING_KEY = "checkout.routingkey";

    public static final String BOOKING_CONFIRMED_QUEUE       = "booking.confirmed.queue";
    public static final String BOOKING_CONFIRMED_EXCHANGE    = "booking.confirmed.exchange";
    public static final String BOOKING_CONFIRMED_ROUTING_KEY = "booking.confirmed.routingkey";

    public static final String BOOKING_CANCELLED_QUEUE       = "booking.cancelled.queue";
    public static final String BOOKING_CANCELLED_EXCHANGE    = "booking.cancelled.exchange";
    public static final String BOOKING_CANCELLED_ROUTING_KEY = "booking.cancelled.routingkey";

    // Checkout
    @Bean
    public Queue checkoutQueue() {
        return new Queue(CHECKOUT_QUEUE);
    }

    @Bean
    public DirectExchange checkoutExchange() {
        return new DirectExchange(CHECKOUT_EXCHANGE);
    }

    @Bean
    public Binding checkoutBinding(Queue checkoutQueue, DirectExchange checkoutExchange) {
        return BindingBuilder.bind(checkoutQueue).to(checkoutExchange).with(CHECKOUT_ROUTING_KEY);
    }

    // Booking Confirmed
    @Bean
    public Queue bookingConfirmedQueue() {
        return new Queue(BOOKING_CONFIRMED_QUEUE);
    }

    @Bean
    public DirectExchange bookingConfirmedExchange() {
        return new DirectExchange(BOOKING_CONFIRMED_EXCHANGE);
    }

    @Bean
    public Binding bookingConfirmedBinding(Queue bookingConfirmedQueue, DirectExchange bookingConfirmedExchange) {
        return BindingBuilder.bind(bookingConfirmedQueue).to(bookingConfirmedExchange).with(BOOKING_CONFIRMED_ROUTING_KEY);
    }

    // Booking Cancelled
    @Bean
    public Queue bookingCancelledQueue() {
        return new Queue(BOOKING_CANCELLED_QUEUE);
    }

    @Bean
    public DirectExchange bookingCancelledExchange() {
        return new DirectExchange(BOOKING_CANCELLED_EXCHANGE);
    }

    @Bean
    public Binding bookingCancelledBinding(Queue bookingCancelledQueue, DirectExchange bookingCancelledExchange) {
        return BindingBuilder.bind(bookingCancelledQueue).to(bookingCancelledExchange).with(BOOKING_CANCELLED_ROUTING_KEY);
    }


}

/*
the three components are:
Queue — a mailbox where messages wait until someone picks them up:
checkout.queue → messages sit here waiting.
Exchange — a post office that receives messages and decides where to send them:
checkout.exchange → receives the message first.
Binding + Routing Key — the rule that connects exchange to queue:
if message has key "checkout.routingkey" → send to "checkout.queue".
*/

/*
The full flow:
BookingService publishes message
      ↓
checkout.exchange receives it
      ↓
sees routing key "checkout.routingkey"
      ↓
routes to checkout.queue
      ↓
BillingService, RoomService, etc listen to that queue
      ↓
each one reacts independently
*/
