package com.springcloud.service.impl;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @author lizz
 * @date 2020/3/30 10:43
 */
public class TestDemo {

    public static String replaceB2C(String a, String b , String c ){

        String rtv = null;
        for(int i = 0; i < a.length(); i++) {
            if (i + b.length() - 1 < a.length()) {
                String aa = a.substring(i, i + b.length());
                if (aa.equals(b)) {
                    a = a.substring(0, i) + c + a.substring(i + b.length());
                    rtv = a;
                    replaceB2C(a, b, c);
                }
            }
        }
        return rtv;
    }

    public static void main(String[] args) {
        String a = "abcdcbbcc";
        String b = "cc";
        String c = "bbb";
//        System.out.println(replaceB2C(a,b,c));
        HashMap map = new HashMap();
//        map.put()
        Hashtable hashtable = new Hashtable();
//        hashtable.put()
        String s= "123";
        System.out.println(s.hashCode());
    }
}
