package com.example.springplayground.demo;

public class JZ384 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        run(s);
        s = "bbbbb";
        run(s);
        s = "b";
        run(s);
        s = "";
        run(s);
    }

    static void run(String s) {
        int n = s.length();
        int[] a = new int[64];
        int start = 0, max = 0;
        for (int i = 0; i < n; i++) {
            int j = s.charAt(i) - 'a';
            if (a[j] >= start) {
                max = Math.max(max, i - start);
                start = i;
            }
            a[j] = i;
        }
        max = Math.max(max, n - start);
        System.out.println(max);
    }
}
