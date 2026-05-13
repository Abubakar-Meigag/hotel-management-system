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

    public static final String CHECKOUT_FANOUT_EXCHANGE         = "checkout.fanout.exchange";
    public static final String CHECKOUT_BILLING_QUEUE           = "checkout.billing.queue";
    public static final String CHECKOUT_HOUSEKEEPING_QUEUE      = "checkout.housekeeping.queue";
    public static final String CHECKOUT_NOTIFICATION_QUEUE      = "checkout.notification.queue";

    public static final String BOOKING_CONFIRMED_QUEUE       = "booking.confirmed.queue";
    public static final String BOOKING_CONFIRMED_EXCHANGE    = "booking.confirmed.exchange";
    public static final String BOOKING_CONFIRMED_ROUTING_KEY = "booking.confirmed.routingkey";

    public static final String BOOKING_CANCELLED_QUEUE       = "booking.cancelled.queue";
    public static final String BOOKING_CANCELLED_EXCHANGE    = "booking.cancelled.exchange";
    public static final String BOOKING_CANCELLED_ROUTING_KEY = "booking.cancelled.routingkey";

    // Checkout
    @Bean
    public FanoutExchange checkoutFanoutExchange() {
        return new FanoutExchange(CHECKOUT_FANOUT_EXCHANGE);
    }

    @Bean
    public Queue checkoutBillingQueue() {
        return new Queue(CHECKOUT_BILLING_QUEUE);
    }

    @Bean
    public Queue checkoutHousekeepingQueue() {
        return new Queue(CHECKOUT_HOUSEKEEPING_QUEUE);
    }

    @Bean
    public Queue checkoutNotificationQueue() {
        return new Queue(CHECKOUT_NOTIFICATION_QUEUE);
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

    // Billing
    @Bean
    public Binding billingBinding() {
        return BindingBuilder.bind(checkoutBillingQueue()).to(checkoutFanoutExchange());
    }

    @Bean
    public Binding housekeepingBinding() {
        return BindingBuilder.bind(checkoutHousekeepingQueue()).to(checkoutFanoutExchange());
    }

    @Bean
    public Binding notificationCheckoutBinding() {
        return BindingBuilder.bind(checkoutNotificationQueue()).to(checkoutFanoutExchange());
    }


}

/*
The three components:
FanoutExchange — receives the message and broadcasts to ALL bound queues.
No routing key needed — fanout ignores it.

checkout.fanout.exchange → broadcasts to:
  - checkout.billing.queue
  - checkout.housekeeping.queue
  - checkout.notification.queue
*/

/*
The full flow:
BookingService publishes message
      ↓
checkout.fanout.exchange receives it
      ↓
broadcasts to ALL three queues simultaneously
      ↓
BillingService        listens to checkout.billing.queue       → creates invoice
HousekeepingService   listens to checkout.housekeeping.queue  → creates cleaning task
NotificationService   listens to checkout.notification.queue  → sends email
      ↓
each one reacts independently and simultaneously
*/
