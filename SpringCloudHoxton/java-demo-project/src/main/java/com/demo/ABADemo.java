package com.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author lizz
 * @date 2020/4/10 15:28
 */
public class ABADemo {

    //普通的原子类
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    //带有版本号的原子类
    static AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(100,1);

    public static void main(String[] args) {

        System.out.println("=============ABA问题的产生==============");
        new Thread(()->{
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);
        },"t1").start();

        new Thread(()->{
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(Thread.currentThread().getName() + ":" + atomicReference.compareAndSet(100, 2020) + "\t" + atomicReference.get());
        },"t2").start();

        try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("=============ABA问题的解决==============");
        new Thread(() -> {
            int stamp = stampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + ";第一次获取版本号" + stamp);
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            stampedReference.compareAndSet(100,101,stamp,stamp + 1);
            System.out.println(Thread.currentThread().getName() + ";第二次获取版本号" + stampedReference.getStamp() + "\t值：" + stampedReference.getReference());
            stampedReference.compareAndSet(101,100,stampedReference.getStamp(),stampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + ";第三次获取版本号" + stampedReference.getStamp() + "\t值：" + stampedReference.getReference());
        },"t3").start();

        new Thread(() ->{
            int stamp = stampedReference.getStamp();
            Integer reference = stampedReference.getReference();
            System.out.println(Thread.currentThread().getName() + ";第一次获取版本号" + stamp);
            try { TimeUnit.SECONDS.sleep(4); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(Thread.currentThread().getName() + "\t CAS结果：" + stampedReference.compareAndSet(reference, reference + 1, stamp, stamp + 1));
        },"t4").start();


    }
}
