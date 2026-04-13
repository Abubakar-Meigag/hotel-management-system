package com.hotel.common.payment;

import com.hotel.common.interfaces.Payment;

import java.math.BigDecimal;

public class CashPayment implements Payment {

    private String cash;

    public CashPayment(String cash) {
        this.cash = cash;
    }

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }

    @Override
    public boolean processPayment(BigDecimal amount) {
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "CASH";
    }
}
