package com.hotel.common.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RoomCharge {

    private String     chargeId;
    private String     description;
    private BigDecimal amount;
    private LocalDate  createAt;

    public RoomCharge(final String chargeId, final String description, final BigDecimal amount, final LocalDate createAt) {
        this.chargeId    = chargeId;
        this.description = description;
        this.amount      = amount;
        this.createAt    = createAt;
    }

    public String getChargeId() {
        return chargeId;
    }

    public void setChargeId(String chargeId) {
        this.chargeId = chargeId;
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

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }
}
