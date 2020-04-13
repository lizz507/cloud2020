package com.demo;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lizz
 * @date 2020/4/10 9:59
 */
public class CASDemo {

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(2);

        System.out.println(atomicInteger.compareAndSet(2, 100));
        System.out.println(atomicInteger.get());
        atomicInteger.getAndIncrement();
        atomicInteger.getAndAdd(2);
        new ArrayList<Integer>().add(1);
        Object[] a = {};
        System.out.println(a);
    }





}
