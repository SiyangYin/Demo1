package com.example.springplayground.demo;

import java.util.Arrays;

public class demo11 {

//    Given an array of numbers, find the minimum difference between any pair in the given array.
//            Examples :
//    Input: { 2, 6, 4, 20, 19, 26 }

    public static int minDiff(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            minDiff = Math.min(minDiff, arr[i + 1] - arr[i]);
        }
        return minDiff;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 6, 4, 20, 19, 26 };
        System.out.println(minDiff(arr));
    }
}
