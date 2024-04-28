package com.example.springplayground.demo;

public class JZ608 {

    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        int t = 9;
        run(a, t);
        a = new int[]{2, 3};
        t = 5;
        run(a, t);
    }

    static void run(int[] a, int t) {
        if (a == null || a.length == 0) return;
        int n =  a.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            if (a[l] + a[r] < t) {
                l++;
            } else if (a[l] + a[r] > t) {
                r--;
            } else {
                System.out.println(String.format("%d, %d", l + 1, r + 1));
                return;
            }
        }
    }
}
