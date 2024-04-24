package com.example.springplayground.demo;

public class demo24 {

    public static void main(String[] args) {
        int[] a = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        bs(a, 67);
        bs(a, 68);
        bs(a, 66);
        bs(a, 1);
        bs(a, 2);
    }

    static void bs(int[] a, int key) {
        int l = 0;
        int r = a.length - 1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (a[m] < key) {
                l = m + 1;
            }
            else if (a[m] > key) {
                r = m - 1;
            }
            else {
                System.out.println(m);
                return;
            }
        }
        System.out.println(-(l + 1));
    }
}
