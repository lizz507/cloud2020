package com.springcloud.service;

import com.springcloud.entities.Payment;

/**
 * @author lizz
 * @date 2020/3/10 15:15
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
