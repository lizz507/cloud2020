package com.springcloud.alibaba.controller;

import com.springcloud.alibaba.domain.Order;
import com.springcloud.alibaba.service.OrderService;
import com.springcloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lizz
 * @date 2020/4/1 16:47
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("order/create")
    public CommonResult createOrder(Order order){
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }

}
