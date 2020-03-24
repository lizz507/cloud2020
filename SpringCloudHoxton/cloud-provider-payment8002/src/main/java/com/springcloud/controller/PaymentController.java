package com.springcloud.controller;

import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;
import com.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author lizz
 * @date 2020/3/10 15:28
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping("payment/create")
    public CommonResult create(@RequestBody  Payment payment){
        log.info("接收参数payment：{}",payment);
        int result = paymentService.create(payment);
        log.info("******************插入结果：" + result);
        if(result > 0 ){
            return new CommonResult(200,"插入数据库正常,port=" + port,result);
        }else{
            return new CommonResult(500,"插入数据库失败,port=" + port);
        }
    }

    @GetMapping("payment/get/{id}")
    public CommonResult get(@PathVariable Long id){
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("******************查询结果：" + paymentById);
        if(paymentById != null){
            return new CommonResult(200,"查询成功,port=" + port,paymentById);
        }else{
            return new CommonResult(500,"查询失败，无此记录：id=[" + id + "] port=" + port);
        }
    }
}
