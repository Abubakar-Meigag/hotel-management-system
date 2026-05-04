package com.hotel.billing.listener;


import com.hotel.billing.model.Invoice;
import com.hotel.billing.service.BillingService;
import com.hotel.common.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CheckoutEventListener {

    private BillingService billingService;

    public CheckoutEventListener(BillingService billingService) {
        this.billingService = billingService;
    }

    @RabbitListener(queues = RabbitMQConfig.CHECKOUT_QUEUE)
    public void handleCheckout(Long bookingId){
        Invoice invoice = new Invoice();
        invoice.setBookingId(bookingId);
        invoice.setStatus("PENDING");

        billingService.generateInvoice(invoice);
    }
}
