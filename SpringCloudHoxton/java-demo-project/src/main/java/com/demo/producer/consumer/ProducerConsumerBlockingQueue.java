package com.demo.producer.consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lizz
 * @date 2020/4/14 15:20
 */
public class ProducerConsumerBlockingQueue {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);
        MyResource myResource = new MyResource(blockingQueue);

//        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                    try {
                        myResource.myProd();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            },"生产者" + 1 + "号").start();
//        }


//        for (int i = 0; i < 8; i++) {
            new Thread(() -> {
                    try {
                        myResource.myConsumer();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            },"消费者" + 1 + "号").start();
//        }

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myResource.stop();
    }
}


class MyResource{
    private volatile boolean FLAG = true;

    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue ){
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProd() throws Exception{
        String data = null;
        boolean retValue;
        while(FLAG){
            data = atomicInteger.incrementAndGet()+"";
            retValue =  blockingQueue.offer(data,2L,TimeUnit.SECONDS);

            if(retValue){
                System.out.println(Thread.currentThread().getName()+"\t 插入队列成功 " + data+" 成功");
            }else{
                System.out.println(Thread.currentThread().getName()+"\t 插入队列 " + data+" 失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"\t 停止了，FLAG="+FLAG);
    }

    public void myConsumer() throws Exception{
        String result = null;
        while(true){
            result = blockingQueue.poll(2L,TimeUnit.SECONDS);
            if(null == result || result.equalsIgnoreCase("")){
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t 超时未取到蛋糕，不买了");
                System.out.println();
                System.out.println();
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName() +"\t 消费成功" + result + " 成功");
        }
    }

    public void stop(){
        FLAG = false;
    }

}


class ShareResource{

    private volatile BlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(10);

    public void put(){
        try {
//            System.out.println(Thread.currentThread().getName() + "\t 生产者开始插入队列");
            blockingQueue.put(new Object());
            System.out.println(Thread.currentThread().getName() + "\t 生产者插入成功 当前存储：" + blockingQueue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void take(){
        try {
//            System.out.println(Thread.currentThread().getName() + "\t 消费者开始消费队列");
            blockingQueue.take();
            System.out.println(Thread.currentThread().getName() + "\t 消费者消费成功 剩余存储：" + blockingQueue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
