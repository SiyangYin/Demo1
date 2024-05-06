package com.example.springplayground.demo;

import java.util.Arrays;

public class JZ807 {

    public static void main(String[] args) {
        int[] a = {0, 3, 4, 6, Integer.MAX_VALUE, Integer.MAX_VALUE >> 1};
        run(a);
    }

    static void run(int[] a) {
        Arrays.stream(a).forEach(i -> {
            run1(i);
            run2(i);
        });
    }

    static void run1(int i) {
        String a = Integer.toBinaryString(i);
        String b = new StringBuilder(a).reverse().toString();
        System.out.println(a);
        System.out.println(a.equals(b));
    }
    
    static void run2(int i) {
        boolean[] bits = new boolean[32];
        int cnt = 0;
        while (i > 0) {
            if ((i & 1) == 1) {
                bits[cnt] = true;
            }
            cnt++;
            i >>= 1;
        }
//        System.out.println(bits);
        for (int j = 0; j < bits.length; j++) {
            System.out.print(bits[j] + ", ");
        }
        System.out.println();
        for (int j = 0; j < cnt / 2; j++) {
            if (bits[j] != bits[cnt - 1 - j]) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }
}
