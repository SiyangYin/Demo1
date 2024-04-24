package com.example.springplayground.demo;

import java.util.Arrays;

public class demo22 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
//        rotate1(a, k);
//        rotate2(a, k);
        rotate3(a, k);
//        rotate4(a, k);
        Arrays.stream(a).forEach(i -> System.out.print(String.format("%s, ", i)));
    }

    static void rotate1(int[] a, int k) {
        if (a == null || a.length <= 1 || k % a.length <= 0) return;
        int n = a.length;
        k = k % n;
        for (int i = 0; i < k; i++) {
            int temp = a[n - 1];
            for (int j = n - 2; j >= 0; j--) {
                a[j + 1] = a[j];
            }
            a[0] = temp;
        }
//        O(kn)
    }

    static void rotate2(int[] a, int k) {
        if (a == null || a.length <= 1 || k % a.length <= 0) return;
        int n = a.length;
        k = k % n;
        int temp = a[0];
        int cur = 0;
        for (int i = 0; i < n - 1; i++) {
            int prev = (cur + n - k) % n;
            a[cur] = a[prev];
            cur = prev;
        }
        a[k] = temp;
        //        O(n)
    }

    static void rotate3(int[] a, int k) {
        if (a == null || a.length <= 1 || k % a.length <= 0) return;
        int n = a.length;
        k = k % n;
        reverse(a, 0, n - 1);
        reverse(a, 0, k - 1);
        reverse(a, k, n - 1);
        //        O(n)
    }

    static void rotate4(int[] a, int k) {
        if (a == null || a.length <= 1 || k % a.length <= 0) return;
        int n = a.length;
        k = k % n;
        reverse(a, 0, n - 1 - k);
        reverse(a, n - k, n - 1);
        reverse(a, 0, n - 1);
        //        O(n)
    }

    static void reverse(int[] a, int start, int end) {
        int mid = start + end >> 1;
        for (int i = start, j = end; i <= mid; i++, j--) {
            swap(a, i, j);
        }
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
