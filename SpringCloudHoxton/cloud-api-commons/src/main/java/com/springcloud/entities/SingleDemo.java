package com.springcloud.entities;


/**
 * @author lizz
 * @date 2020/4/9 18:18
 */
public class SingleDemo {

    private static volatile SingleDemo instance = null;

    private SingleDemo(){
        System.out.println(Thread.currentThread().getName() + ":创建成功");
    }


    public static  SingleDemo getInstance(){
        if(instance == null){
            synchronized (SingleDemo.class){
                if(instance == null){
                    instance = new SingleDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                SingleDemo.getInstance();
            }).start();
        }
    }
}
