package com.example.springplayground.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class demo29 {

    public static void main(String[] args) {
        String s = "asdfghfgdfgfgggertt";
        run(s);
//        g-6
//        f-4
//        d-2
//        t-2
//        a-1
//        E-1
//        h-1
    }

    static void run(String s) {
        if (s == null || s.length() <= 0) return;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> collect =
                map.entrySet().stream().sorted((i1, i2) -> i1.getValue() != i2.getValue() ?
                        i2.getValue() - i1.getValue() :
                        i1.getKey().compareTo(i2.getKey())).collect(Collectors.toList());
        System.out.println(collect);
    }
}
