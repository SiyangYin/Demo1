package com.example.springplayground.demo;

import java.util.Arrays;

public class JZ588 {

    public static void main(String[] args) {
        int[] a = {1, 5, 11, 5};
        run(a);
        a = new int[]{1, 2, 3, 9};
        run(a);
    }

    static void run(int[] a) {
        int sum = Arrays.stream(a).sum();
        if (sum % 2 == 1) {
            System.out.println(false);
            return;
        }
        boolean[] f = new boolean[sum / 2 + 1];
        f[0] = true;
        for (int i : a) {
            for (int j = sum / 2; j >= i; j--) {
                f[j] |= f[j - i];
            }
        }
        System.out.println(f[sum / 2]);
    }
}
