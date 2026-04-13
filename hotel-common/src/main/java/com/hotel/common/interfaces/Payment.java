package com.hotel.common.interfaces;

import java.math.BigDecimal;

public interface Payment {

    boolean processPayment(BigDecimal amount);
    String getPaymentMethod();
}

