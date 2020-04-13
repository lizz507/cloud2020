package com.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author lizz
 * @date 2020/4/13 10:57
 *
 * 自旋锁手写案例
 */
public class SpinLockDemo {

     AtomicReference<Thread> reference = new AtomicReference<>();
     int count = 0;

    public  void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "\t 开始获取锁" );

        while(!reference.compareAndSet(null,thread)){

        }
        System.out.println(Thread.currentThread().getName() + "\t 获取锁成功" );
    }

    public void myUnLock(){
        Thread thread = Thread.currentThread();
        while(!reference.compareAndSet(thread,null)){

        }
        System.out.println(Thread.currentThread().getName() + "\t 释放锁成功");
    }

    public void add(){
        count++;
    }

    public synchronized  void plus(){
        count++;
    }


    public static void main(String[] args) {
        SpinLockDemo spinLock = new SpinLockDemo();




        //自定义自旋锁效率测试
//        final long l = System.currentTimeMillis();
//        for (int i = 0; i < 100 * 1000; i++) {
//            new Thread(() ->{
//                spinLock.myLock();
//                spinLock.add();
//                spinLock.myUnLock();
//            }).start();
//        }
//
//
//        while(Thread.activeCount() > 2){
//
//        }
//
//
//        System.out.println(System.currentTimeMillis() - l);
//        System.out.println(spinLock.count);


        //synchronized效率测试
//        final long ll = System.currentTimeMillis();
//        for (int i = 0; i < 100 * 1000; i++) {
//            new Thread(() ->{
//                spinLock.plus();
//            }).start();
//        }
//        System.out.println(System.currentTimeMillis() - ll);
//        System.out.println(spinLock.count);




        new Thread(() ->{
            spinLock.myLock();
            try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(Thread.currentThread().getName() + "\t do something...");
            spinLock.myUnLock();
        },"t1").start();

        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

        new Thread(() ->{
            spinLock.myLock();
            System.out.println(Thread.currentThread().getName() + "\t do something...");
            spinLock.myUnLock();
        },"t2").start();


    }
}
