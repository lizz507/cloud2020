package com.demo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author lizz
 * @date 2020/4/10 16:47
 */
public class ContainerNotSafeDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        List<String> list1 = Collections.synchronizedList(new ArrayList<String>());
        CopyOnWriteArrayList<String> copy = new CopyOnWriteArrayList<>();
//        CopyOnWriteArraySet
        copy.get(1);
//        final HashSet<String> set = new HashSet<>();
//        final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
//        map.put("1","1");
//        final TreeMap<String, String> treeMap = new TreeMap<>();
//        treeMap.put()
//        final Hashtable<String, String> tab = new Hashtable<>();
//        tab.put()
//        set.add("1")
//        set.iterator()
//        copy.contains()
        copy.remove(1);
        list1.add("1");

        for (int i = 0; i < 100; i++) {
            new Thread(() ->{
                list.add(UUID.randomUUID().toString());
                System.out.println(list);
            }).start();
        }
    }
}
