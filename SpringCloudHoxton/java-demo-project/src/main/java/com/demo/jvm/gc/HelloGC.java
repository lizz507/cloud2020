package com.demo.jvm.gc;

/**
 * @author lizz
 * @date 2020/4/16 14:50
 */
public class HelloGC {
    public static void main(String[] args) {
        System.out.println("********************HelloGC");

        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
