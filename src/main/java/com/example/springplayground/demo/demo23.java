package com.example.springplayground.demo;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class demo23 {

    public static void main(String[] args) {
        int[] a = {16, 17, 4, 3, 5, 2};
        leaders1(a);
        leaders2(a);
    }

    static void leaders1(int[] a) {
        if (a == null || a.length == 0) return;
        int n = a.length;
        Stack<Integer> stack = new Stack<>();
        int max = a[n - 1];
        stack.push(a[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] > max) {
                stack.push(a[i]);
                max = a[i];
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(String.format("%s, ", stack.pop()));
        }
//        System.out.println(stack);
    }

    static void leaders2(int[] a) {
        if (a == null || a.length == 0) return;
        int n = a.length;
        LinkedList<Integer> l = new LinkedList<>();
        int max = a[n - 1];
        l.add(a[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] > max) {
                l.addFirst(a[i]);
                max = a[i];
            }
        }
        System.out.println(l);
    }
}
