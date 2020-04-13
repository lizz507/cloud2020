package com.springcloud.entities;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lizz
 * @date 2020/4/9 16:52
 */
public class testVolatile {

//    volatile int number = 0;
        volatile AtomicInteger number = new AtomicInteger();

//    public void setNumber(){
//        this.number = 60;
//    }
//
//    public int getNumber(){
//        return this.number;
//    }

    public void numberPlusPlus(){
//        number++;
        number.getAndIncrement();
    }

    public static void main(String[] args) {

        testVolatile testVolatile = new testVolatile();

        for (int i = 0; i < 20; i++) {
            new Thread(() ->{
                for (int j = 0; j < 1000; j++) {
                    testVolatile.numberPlusPlus();
                }
            }).start();
        }
        while(Thread.activeCount() > 2){

        }
        System.out.println(testVolatile.number.get());
    }

//    private static void see() {
//        testVolatile testVolatile = new testVolatile();
//
//        new Thread(() ->{
//            testVolatile.setNumber();
//            System.out.println(Thread.currentThread().getName() +  testVolatile.getNumber());
//            try {
//                Thread.sleep(6000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//
//        while(testVolatile.number == 0){
//
//        }
//        System.out.println("stop " + Thread.currentThread().getName() +"  " +  testVolatile.getNumber());
//    }
}
