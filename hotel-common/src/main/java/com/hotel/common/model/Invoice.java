package com.hotel.common.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Invoice {

    private String invoiceId;
    private RoomBooking roomBooking;
    private BigDecimal totalAmount;
    private LocalDate createAt;
    private List<RoomCharge> charges;

    public Invoice(String invoiceId, RoomBooking roomBooking, BigDecimal totalAmount, LocalDate createAt) {
        this.invoiceId   = invoiceId;
        this.roomBooking = roomBooking;
        this.totalAmount = totalAmount;
        this.createAt    = createAt;
        this.charges     = new ArrayList<>();
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public RoomBooking getRoomBooking() {
        return roomBooking;
    }

    public void setRoomBooking(RoomBooking roomBooking) {
        this.roomBooking = roomBooking;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    public List<RoomCharge> getCharges() {
        return charges;
    }

    public void setCharges(List<RoomCharge> charges) {
        this.charges = charges;
    }
}
