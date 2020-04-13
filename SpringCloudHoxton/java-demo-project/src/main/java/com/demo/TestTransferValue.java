package com.demo;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lizz
 * @date 2020/4/10 18:34
 */
public class TestTransferValue {

    static void a(String s){
        System.out.println(s);
    }


    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";
        String c= new String("abc");
        System.out.println(a.equals(b));
        System.out.println(b == c);
        System.out.println(c == a);
        ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
//        map.put()
    }
}
