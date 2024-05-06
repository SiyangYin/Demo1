package com.example.springplayground.demo;

import java.util.*;

public class JZ657 {

    static List<Integer> list = new ArrayList<>();
    static Map<Integer, Integer> map = new HashMap<>();
    static Random random = new Random();
    public static void main(String[] args) {
        run();
    }

    static void run() {
        insert(1);
        remove(2);
        insert(2);
        get();
        remove(1);
        insert(2);
        get();
    }

    static void insert(int val) {
        if (map.containsKey(val)) {
            System.out.println(false);
            return;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        System.out.println(true);
    }

    static void remove(int val) {
        if (!map.containsKey(val)) {
            System.out.println(false);
            return;
        }
        int i = map.get(val);
        int lasVal = list.get(list.size() - 1);
        list.set(i, lasVal);
        list.remove(list.size() - 1);
        map.put(lasVal, i);
        map.remove(val);
        System.out.println(true);
    }

    static void get() {
        System.out.println(list.get(random.nextInt(list.size())));
    }
}
