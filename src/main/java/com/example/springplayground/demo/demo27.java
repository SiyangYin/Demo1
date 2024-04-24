package com.example.springplayground.demo;

import java.util.Arrays;

public class demo27 {

    public static void main(String[] args) {
        int[] a = {0, -1, 1, 3};
        int[] b = {11, 13, 8, 7};
        int[] c = {1, 2, 0};
        System.out.println(findMiss(a));
        System.out.println(findMiss(b));
        System.out.println(findMiss(c));
    }

    static int findMiss(int[] a) {
        if (a == null || a.length == 0) return 1;
        Arrays.sort(a);
        int n = a.length;
        int i;
        for (i = 0; i < n; i++) {
            if (a[i] > 0) {
                break;
            }
        }
        int k = 1;
        for (int j = i; j < n; j++) {
            if (a[j] != k) {
                return k;
            }
            k++;
        }
        return k;
    }
}
