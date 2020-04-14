package com.demo.producer.consumer;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lizz
 * @date 2020/4/14 10:48
 */
public class ProducerConsumerReentrantLock {


    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        new Thread(() ->{
            for (int i = 0; i < 5; i++) {
                sharedData.increment();
            }
        },"A").start();

        new Thread(() ->{
            for (int i = 0; i < 5; i++) {
                sharedData.increment();
            }
        },"Aa").start();

        new Thread(() ->{
            for (int i = 0; i < 5; i++) {
                sharedData.decrement();
            }
        },"B").start();

        new Thread(() ->{
            for (int i = 0; i < 5; i++) {
                sharedData.decrement();
            }
        },"Bb").start();




    }

}

class SharedData{

    private int number = 0;

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment(){

        lock.lock();

        try{
            while(number != 0 ){
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public void decrement(){

        lock.lock();
        try{
            while(number == 0 ){
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }


}

