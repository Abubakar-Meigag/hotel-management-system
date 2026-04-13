package com.hotel.common.payment;

import com.hotel.common.interfaces.Payment;

import java.math.BigDecimal;

public class CreditCardPayment implements Payment {

    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String getPaymentMethod() {
        return "CREDIT_CARD";
    }

    @Override
    public boolean processPayment(BigDecimal amount) {
        return true;
    }
}
