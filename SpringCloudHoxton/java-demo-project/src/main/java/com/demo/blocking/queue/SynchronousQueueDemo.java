package com.demo.blocking.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author lizz
 * @date 2020/4/13 17:47
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) {
        SynchronousQueue<String> blockingQueue = new SynchronousQueue<>();

        new Thread(() ->{
            try {
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName() + "\t put 1 success");

                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName() + "\t put 2 success");

                blockingQueue.put("3");
                System.out.println(Thread.currentThread().getName() + "\t put 3 success");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();


        new Thread(() ->{
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "\t 获取值：" + blockingQueue.take());

                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "\t 获取值：" + blockingQueue.take());

                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "\t 获取值：" + blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2");
    }
}
