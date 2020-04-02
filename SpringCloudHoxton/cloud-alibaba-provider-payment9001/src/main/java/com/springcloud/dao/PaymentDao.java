package com.springcloud.dao;

import com.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author lizz
 * @date 2020/3/10 14:51
 */
@Mapper
public interface PaymentDao{
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
