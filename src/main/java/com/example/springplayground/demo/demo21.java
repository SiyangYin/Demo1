package com.example.springplayground.demo;

import java.util.*;
import java.util.stream.Collectors;

public class demo21 {

    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1, 2, 3, 4, 5);
        Integer integer = l.stream().collect(Collectors.maxBy(Comparator.comparing(i -> i))).get();
        System.out.println(integer);
        List<Integer> collect = l.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(collect);
        Integer integer1 = l.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(integer1);
    }
}
