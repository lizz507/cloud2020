package com.springcloud.service.impl;

import com.springcloud.dao.PaymentDao;
import com.springcloud.entities.Payment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * @author lizz
 * @date 2020/3/31 10:16
 */
@Service
public class PaymentServiceImpl_2 {

    @Resource
    private PaymentDao paymentDao;


    @Transactional
    public int create(Payment payment) {
        paymentDao.create(payment);
//        int i = 1 / 0;
        return  1;
    }
}
