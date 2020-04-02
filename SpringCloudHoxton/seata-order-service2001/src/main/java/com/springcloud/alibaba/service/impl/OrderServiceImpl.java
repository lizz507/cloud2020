package com.springcloud.alibaba.service.impl;

import com.springcloud.alibaba.dao.OrderDao;
import com.springcloud.alibaba.domain.Order;
import com.springcloud.alibaba.service.AccountService;
import com.springcloud.alibaba.service.OrderService;
import com.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lizz
 * @date 2020/4/1 14:52
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private AccountService accountService;

    @Resource
    private StorageService storageService;

    @Override
    @GlobalTransactional
    public void create(Order order) {

        log.info("----->开始创建订单,order{}",order);
        orderDao.create(order);
        log.info("----->订单微服务开始调用库存，做扣减");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("----->库存扣减成功,end");
        log.info("----->开始扣钱，start");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("----->账户扣减成功,end");

        log.info("----->开始修改订单状态");
        orderDao.update(order.getUserId(),0);
        log.info("----->订单状态修改成功，订单完成");


    }
}
