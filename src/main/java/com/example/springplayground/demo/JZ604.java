package com.example.springplayground.demo;

import java.util.Arrays;

public class JZ604 {

    public static void main(String[] args) {
        int[] a = {1, 2, 7, 8, 5};
        int k = 3;
        run(a, k);
    }

    static void run(int[] a, int k) {
        if (a == null || a.length < k || k <= 0) return;
        int n = a.length;
        int[] sum = new int[n - k + 1];
        for (int i = 0; i < k; i++) {
            sum[0] += a[i];
        }
        for (int i = 1; i < n - k + 1; i++) {
            sum[i] = sum[i - 1] - a[i - 1] + a[i + k - 1];
        }
        Arrays.stream(sum).forEach(i -> System.out.print(String.format("%d, ", i)));
    }
}
