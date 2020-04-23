package com.demo.thread.demo;

import java.util.concurrent.*;

/**
 * @author lizz
 * @date 2020/4/14 18:05
 */
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyCallable());
//        FutureTask<Integer> futureTask1 = new FutureTask<>(new MyCallable());
//        Thread t = new Thread(futureTask);
//        Thread t1 = new Thread(futureTask1);
//        t.start();
//        t1.start();

        futureTask.get();
        final Future<Integer> submit = Executors.newFixedThreadPool(10).submit(new MyCallable());

        while(!futureTask.isDone()){
            System.out.println("没算完");
        }

        final Integer integer = futureTask.get();
        System.out.println(integer);


//        final Integer integer1 = futureTask1.get();
//        System.out.println(integer1);
//        System.out.println("我是main");



        System.out.println(1+integer);
    }
}

class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        TimeUnit.SECONDS.sleep(5);
        return 1024;
    }
}
