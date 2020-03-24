package com.cloud.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author lizz
 * @date 2020/3/13 17:29
 */
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    private String INVOKE_URL = "http://cloud-provider-payment";

    @GetMapping("/consumer/payment/consul")
    public String getPayment(){
        return restTemplate.getForObject(INVOKE_URL + "/payment/consul",String.class);
    }

}
