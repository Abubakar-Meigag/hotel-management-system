package com.hotel.billing.controller;


import com.hotel.billing.model.Invoice;
import com.hotel.billing.model.RoomCharge;
import com.hotel.billing.service.BillingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/billing")
public class BillingController {


    private BillingService billingService;

    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    @PostMapping("/invoice")
    public Invoice generateNewInvoice(@RequestBody Invoice invoice){
        return billingService.generateInvoice(invoice);
    }

    @PostMapping("/charge")
    public RoomCharge addChage(@RequestBody RoomCharge roomCharge){
        return billingService.addCharge(roomCharge);
    }

    @GetMapping("/invoice/{bookingId}")
    public Invoice getInvoiceByBookingId(@PathVariable Long bookingId){
        return billingService.getInvoiceByBookingId(bookingId);
    }
}
