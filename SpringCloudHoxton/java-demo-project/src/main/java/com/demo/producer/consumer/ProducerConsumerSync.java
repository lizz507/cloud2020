package com.demo.producer.consumer;

import java.util.concurrent.TimeUnit;

/**
 * @author lizz
 * @date 2020/4/14 10:05
 */
public class ProducerConsumerSync {

    public static void main(String[] args) {
        Shop shop = new Shop(5);


        //三个生产者
        for (int i = 0; i < 5; i++) {
            new Producer(shop,"生产者"+i+"号").start();
        }

        //十个消费者
        for (int i = 0; i < 2; i++) {
            new Consumer(shop,"消费者"+i+"号").start();
        }
    }

}

class Producer extends Thread{

    private Shop shop;

    @Override
    public void run() {
        while(true) {

            shop.product();

        }
    }

    Producer(Shop shop,String name){
        super(name);
        this.shop = shop;
    }
}


class Consumer extends Thread{
    private Shop shop;

    @Override
    public void run() {
        while(true) {

            shop.sale();

        }
    }

    Consumer(Shop shop,String name){
        super(name);
        this.shop = shop;
    }
}



class Shop{

    private volatile int number;

    public synchronized void sale(){
        while(number == 0){
            try {
                System.out.println(Thread.currentThread().getName() + "\t#######################库存没了，等到生产者生产...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

            System.out.println(Thread.currentThread().getName() + "\t 消费者开始消费，当前库存为：" + this.getNumber());
            number--;
            System.out.println(Thread.currentThread().getName() + "\t 消费者消费完成，剩余库存为：" + this.getNumber());
            notifyAll();

    }

    public synchronized void product() {
        while (this.getNumber()>= 10) {
            try {
                wait();
                System.out.println(Thread.currentThread().getName() + "\t 货源充足，不用生产了，休息一会");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            System.out.println(Thread.currentThread().getName() + "\t 开始生产,当前店铺库存：" + this.getNumber());
            number++;
            System.out.println(Thread.currentThread().getName() + "\t 生产完成，库存+1，当前库存：" + this.getNumber());
//            if (number == 1) {
                notifyAll();
                System.out.println(Thread.currentThread().getName() + "\t########################新鲜出炉，你们过来买吧");
//            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


    }

    public int getNumber() {
        return number;
    }

    public Shop(int number) {
        this.number = number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

