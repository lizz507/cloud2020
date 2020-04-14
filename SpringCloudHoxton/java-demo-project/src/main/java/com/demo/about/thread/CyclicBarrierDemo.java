package com.demo.about.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author lizz
 * @date 2020/4/13 16:07
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,() ->{
            System.out.println(Thread.currentThread().getName() + "\t： 干得漂亮，任务完结");
        });

        for (int i = 0; i < 7; i++) {
            new Thread(() ->{
                System.out.println(Thread.currentThread().getName()+"\t 报告：完成任务!");
                try {
                    cyclicBarrier.await();
                    System.out.println("人到齐了吗？");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },i+"号").start();
        }
    }
}
