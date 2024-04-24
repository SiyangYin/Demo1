package com.example.springplayground.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class demo10 {

//    Given k sorted arrays of size n each, merge them and print the sorted output
//    k = 4, n = 4
//    arr[][] = { {1, 5, 6, 8},
//        {2, 4, 10, 12},
//        {3, 7, 9, 11},
//        {13, 14, 15, 16}} ;
//    Output: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
//    Explanation: The output array is a sorted array that contains all the elements of the input matrix.

    public static List<Integer> merge(int[][] arr) {
        if (arr == null || arr.length == 0 || arr[0].length == 0) return null;
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>((i1, i2) -> arr[i1.get(0)][i1.get(1)] - arr[i2.get(0)][i2.get(1)]);
        for (int i = 0; i < arr.length; i++) {
            minHeap.offer(Arrays.asList(i, 0));
        }
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            List<Integer> list = minHeap.poll();
            result.add(arr[list.get(0)][list.get(1)]);
            if (list.get(1) < arr[0].length - 1) {
                list.set(1, list.get(1) + 1);
                minHeap.offer(list);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = { {1, 5, 6, 8},
        {2, 4, 10, 12},
        {3, 7, 9, 11},
        {13, 14, 15, 16}} ;
        System.out.println(merge(arr));
    }
}
