package com.demo.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lizz
 * @date 2020/4/14 14:56
 */
public class SyncAndReentrantLockDemo {


    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(() ->{
            for (int i = 0; i < 10; i++) {

                shareResource.print(1);
            }
        },"A").start();

        new Thread(() ->{
            for (int i = 0; i < 10; i++) {

                shareResource.print(2);
            }
        },"B").start();

        new Thread(() ->{
            for (int i = 0; i < 10; i++) {

                shareResource.print(3);
            }
        },"C").start();



    }
}

class ShareResource{

    private int number = 1;
    private ReentrantLock lock = new ReentrantLock();

//    private Condition c1 = lock.newCondition();
//    private Condition c2 = lock.newCondition();
    private Condition [] conditions = {lock.newCondition(),lock.newCondition(),lock.newCondition()};


    public void print(int count){
        lock.lock();
        try{
            while(number != count){
                conditions[count - 1].await();
            }
            for (int i = 0; i < count * 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" +i);
            }
            number = count + 1 == 4 ? 1 : count + 1;
            conditions[count == 3 ? 0:count].signal();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

}
