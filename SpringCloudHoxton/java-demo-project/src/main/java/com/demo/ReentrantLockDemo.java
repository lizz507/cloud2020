package com.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lizz
 * @date 2020/4/13 10:22
 *
 * 同一线程外层函数获得锁之后，内层递归函数仍然可以获取该锁的代码，同一线程在
 * 外层方法获取锁的时候，进入内层方法会自动获取锁。
 * 线程可以进入任何一个它已经拥有的锁所同步着的代码块。
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        Phone phone = new Phone();


        //synchronized 可重入验证

        new Thread(() -> {
            phone.sendSMS();
        },"t1").start();
        new Thread(() -> {
            phone.sendSMS();
        },"t2").start();

        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        //ReentrantLock 可重入验证

        Thread t3 = new Thread(phone);
        Thread t4  = new Thread(phone);
        t3.start();
        t4.start();




    }

}

class Phone implements Runnable{
    public synchronized void sendSMS(){
        System.out.println(Thread.currentThread().getName()+"\t ######sendSMS");
        sendEmail();
    }

    public synchronized  void sendEmail(){
        System.out.println(Thread.currentThread().getName() + "\t #######sendEamil" );
    }


    // =======================ReentrantLock 可重入锁测试========================

    Lock lock = new ReentrantLock();

    public void get(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t ###############get()");
            set();
        }finally {
            lock.unlock();
        }
    }

    private void set() {
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + "\t ################set()");
        }finally {
            lock.unlock();
        }
    }


    @Override
    public void run() {
        get();
    }
}
