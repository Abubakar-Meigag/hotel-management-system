package com.hotel.billing.service;


import com.hotel.billing.model.Invoice;
import com.hotel.billing.model.RoomCharge;
import com.hotel.billing.repository.InvoiceRepository;
import com.hotel.billing.repository.RoomChargeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillingService {

    private InvoiceRepository invoiceRepository;
    private RoomChargeRepository roomChargeRepository;

    public BillingService(InvoiceRepository invoiceRepository, RoomChargeRepository roomChargeRepository) {
        this.invoiceRepository = invoiceRepository;
        this.roomChargeRepository = roomChargeRepository;
    }

    public Invoice generateInvoice(Invoice invoice){
        return invoiceRepository.save(invoice);
    }

    public RoomCharge addCharge(RoomCharge charge){
        return roomChargeRepository.save(charge);
    }

    public Invoice getInvoiceByBookingId(Long bookingId){
        Optional<Invoice> optional = invoiceRepository.findByBookingId(bookingId);

        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }
}
