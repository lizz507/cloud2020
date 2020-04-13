package com.demo;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author lizz
 * @date 2020/4/10 15:10
 */
public class AtomicReferenceDemo {

    public static void main(String[] args) {
        AtomicReference<User> reference = new AtomicReference<>();
        User user = new User("张三",24);
        User user2 = new User("李四",24);


        reference.set(user);
        user.setName("王五");
        user = new User("张三丰",999);
        System.out.println(reference.compareAndSet(user, user2));

        System.out.println(reference.get().getName());
    }
}


class User{
    public String name;

    public Integer age;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public User() {
    }
}
