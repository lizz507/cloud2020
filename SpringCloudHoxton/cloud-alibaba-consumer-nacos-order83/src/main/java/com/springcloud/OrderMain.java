package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lizz
 * @date 2020/3/24 14:57
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMain {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain.class,args);
    }
}
