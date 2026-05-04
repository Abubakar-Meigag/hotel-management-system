package com.hotel.billing.model;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "billing")
public class Invoice {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private Long bookingId;
    private BigDecimal totalAmount;
    private LocalDate createAt;
    private String status;

    public Invoice(Long id, Long bookingId, BigDecimal totalAmount, LocalDate createAt, String status) {
        this.id = id;
        this.bookingId = bookingId;
        this.totalAmount = totalAmount;
        this.createAt = createAt;
        this.status = status;
    }

    public Invoice(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
