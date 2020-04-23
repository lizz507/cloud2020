package com.demo.thread.demo;

/**
 * @author lizz
 * @date 2020/4/15 15:34
 */
public class DeadLockDemo {

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new ThreadLockHold(lockA,lockB),"A").start();
        new Thread(new ThreadLockHold(lockB,lockA),"B").start();
    }
}
class ThreadLockHold implements Runnable{

    String lockA;
    String lockB;

    public ThreadLockHold(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"\t我现在拿到了"+lockA + "的锁："+"\t还需要"+lockB + "的锁");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"\t 两个锁都拿到了，圆满了");
            }
        }
    }
}

//class ResourceA{
//
//    private ResourceB resourceB;
//
//    public synchronized void methodA(){
//        System.out.println(Thread.currentThread().getName()+"\t我拿到了A的锁，现在我想得到B的锁,不过我累了，休息一下再拿");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
////        resourceB.methodB();
//    }
//    ResourceA(){
//    }
//
//    public void setResourceB(ResourceB resourceB){
//        this.resourceB = resourceB;
//    }
//
//
//}

//class ResourceB{
//
//    private ResourceA resourceA;
//
//    public synchronized void methodB(){
//        System.out.println(Thread.currentThread().getName()+"\t我拿到了B的锁，现在我还需要A的锁");
////        resourceA.methodA();
//    }
//
//    ResourceB(){
//    }
//
//    public void setResourceA(ResourceA resourceA){
//        this.resourceA = resourceA;
//    }
//
//}

