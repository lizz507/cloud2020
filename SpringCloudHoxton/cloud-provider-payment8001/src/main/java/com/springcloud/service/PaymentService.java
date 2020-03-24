package com.springcloud.service;

import com.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author lizz
 * @date 2020/3/10 15:15
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
