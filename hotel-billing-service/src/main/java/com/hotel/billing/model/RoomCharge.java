package com.hotel.billing.model;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "room_charge")
public class RoomCharge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private Long invoiceId;
    private String description;
    private BigDecimal amount;

    public RoomCharge(Long id, Long invoiceId, String description, BigDecimal amount) {
        this.id = id;
        this.invoiceId = invoiceId;
        this.description = description;
        this.amount = amount;
    }

    public RoomCharge(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
