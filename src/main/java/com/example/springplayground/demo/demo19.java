package com.example.springplayground.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class demo19 {

    public static void main(String[] args) {
        Integer[] a = {1,2,3,4,5,6,7};
        List<Integer> l = Arrays.stream(a).collect(Collectors.toList());
        System.out.println(l);
        Collections.reverse(l);
        System.out.println(l);
        Collections.reverse(l);
        System.out.println(l);
        Collections.rotate(l, 3);
        System.out.println(l);
    }
}
