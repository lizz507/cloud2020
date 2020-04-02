package com.springcloud.service.impl;

import com.springcloud.dao.PaymentDao;
import com.springcloud.entities.Payment;
import com.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * @author lizz
 * @date 2020/3/10 15:17
 */

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Autowired
    private PaymentServiceImpl_2 paymentServiceImpl_2;

    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;
    @Override
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int create(Payment payment) {
        System.out.println("这是datasource：" + dataSourceTransactionManager.getDataSource());
        try {
            System.out.println("这是create方法的connection:" + dataSourceTransactionManager.getDataSource().getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return  paymentDao.create(payment);
//        return 1 / 0;
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }



    /***************************************************************************/
    @Transactional
    public void testTrans(Payment payment){
//        System.out.println("这是testTrans方法的datasource：" + dataSourceTransactionManager.getDataSource());
//        try {
//            System.out.println("这是testTrans方法的connection：" + dataSourceTransactionManager.getDataSource().getConnection());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        log.info("************开始插入");
//        create(payment);
//        try {

            for (int i = 0; i < 10; i++) {
                new Thread(() ->{
                    paymentServiceImpl_2.create(payment);
                    int ii = 1/0;
                }).start();
            }
//        }catch (ArithmeticException a){
//            a.getCause();
//        }
//        paymentServiceImpl_2.create(payment);
        int ii = 1/0;
        log.info("**************插入数据成功，制造异常");
//        int i = 10 / 0;
    }
}
