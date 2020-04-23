package com.demo.thread.demo;

import java.util.Collections;
import java.util.concurrent.*;

/**
 * @author lizz
 * @date 2020/4/15 10:06
 *
 *
 * 第四种创建线程的方式
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {

        //固定容量的线程池，适合执行长期的任务
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //单一线程的线程池，适合执行顺序的任务
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        //容量可变的线程池，适合执行短期的任务
//        ExecutorService executorService = Executors.newCachedThreadPool();

        //没法接收新请求就会抛出异常
        ExecutorService executorService2 = new ThreadPoolExecutor(2,5,0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(3),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        //没法接收新的请求就将请求回退到调用者，让调用者执行这个任务
        ExecutorService executorService3 = new ThreadPoolExecutor(2,5,0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(3),Executors.defaultThreadFactory(),new ThreadPoolExecutor.CallerRunsPolicy());

        //没法接收新的请求就把阻塞队列中最早的那个任务请求丢掉，然后把当前的任务请求插入到阻塞队列
        ExecutorService executorService4 = new ThreadPoolExecutor(2,5,0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(3),Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardOldestPolicy());

        //没法接收新的请求就丢掉
        ExecutorService executorService5 = new ThreadPoolExecutor(2,5,0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(3),Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardPolicy());
        try {
            for (int i = 1; i < 15; i++) {
                final int temp = i;
                executorService2.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " " + temp + "号\t 办理业务");
                });
//                Thread.sleep(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executorService2.shutdown();
        }



    }
}
