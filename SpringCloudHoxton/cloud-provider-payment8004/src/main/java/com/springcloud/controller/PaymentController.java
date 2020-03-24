package com.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;

/**
 * @author lizz
 * @date 2020/3/12 17:54
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    /**
     * http://localhost:8004/payment/zk
     *
     * @return
     */
    @RequestMapping(value = "payment/zk")
    public String paymentZk() {
        return "SpringCloud with zookeeper:" + serverPort + "\t" + UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        String s = "s";
//        s.toCharArray()
//        s.toLowerCase();
        HashMap<Character,Integer> map = new HashMap<>();
//        map.containsKey()
        map.size();
        int maxCount = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() >= maxCount){
                System.out.println();
            }
        }
//        Map
//        Character
//        int i = 1;
//        Integer ii = new Integer(10);
//        System.out.println(i == ii);
        TreeSet<Character> set  = new TreeSet<>();
        set.add('b');
        set.add('a');
        set.add('z');
        set.add('1');
        System.out.println(set.first());
    }
}
