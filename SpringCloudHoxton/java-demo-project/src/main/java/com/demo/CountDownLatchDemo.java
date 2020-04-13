package com.demo;

import java.util.concurrent.CountDownLatch;

/**
 * @author lizz
 * @date 2020/4/13 15:18
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(() ->{
                System.out.println(Thread.currentThread().getName()+"\t 执行结束了");
                countDownLatch.countDown();
            },i+"").start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"主线程执行完毕，over");

    }
}

enum MyEnum {

    ONE(1,"A"),TWO(2,"B"),THREE(3,"C"),FOUR(4,"D"),FIVE(5,"E"),SIX(6,"F");

    private int code;

    private String value;

    MyEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    static String getValueByCode(int code) {
        MyEnum[] values = MyEnum.values();
        for (MyEnum value : values) {
            if (code == value.getCode()) {
                return value.getValue();
            }
        }
        return null;
    }

}
