package com.hotel.common.payment;

import com.hotel.common.interfaces.Payment;

import java.math.BigDecimal;

public class CheckPayment implements Payment {

    private String checkNumber;

    public CheckPayment(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    @Override
    public boolean processPayment(BigDecimal amount) {
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "CHECK";
    }
}
