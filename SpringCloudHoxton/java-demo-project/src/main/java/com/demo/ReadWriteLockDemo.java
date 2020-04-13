package com.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author lizz
 * @date 2020/4/13 14:22
 */
public class ReadWriteLockDemo {


    public static void main(String[] args) {

        MyCache cache = new MyCache();

        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() ->{
                cache.put(temp+"",temp+"");
            },"w"+i).start();
        }

        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() ->{
                cache.get(temp+"");
            },"r"+i).start();
        }

    }

}


class MyCache{

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private Map<String,Object> map = new HashMap<>();

    public void put(String key,Object value){
        try {
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "\t 开始写入:" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t 写入完成");
        }finally {
            lock.writeLock().unlock();
        }
    }

    public void get(String key){
        try {
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + "\t 开始读:" + key);
            final Object o = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读成功:" + o);
        }finally {
            lock.readLock().unlock();
        }
    }


}

