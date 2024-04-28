package com.example.springplayground.demo;

import java.util.Arrays;

public class JZ395 {

    public static void main(String[] args) {
        int[] a = {1, 2, 2};
        run(a);
        a = new int[]{1, 2, 4};
        run(a);
    }

    static void run(int[] a) {
        int n = a.length;
        int[] f = new int[n];
        int sum = Arrays.stream(a).sum();
        f[0] = a[0];
        f[1] = a[0] + a[1];
        f[2] = a[0] + a[1];
        for (int i = 3; i < n; i++) {
            f[i] = Math.max(Math.max(f[i - 1] + a[i], f[i - 2] + a[i]), f[i - 3] + a[i]);
        }
        System.out.println(f[n - 1] > sum / 2);
    }
}
