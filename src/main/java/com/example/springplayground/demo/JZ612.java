package com.example.springplayground.demo;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class JZ612 {

    public static void main(String[] args) {
        int[][] p = {{4, 6}, {4, 7}, {4, 4}, {2, 5}, {1, 1}};
        int[] o = {0, 0};
        int k = 3;
        run1(p, o, k);
        run2(p, o, k);
        p = new int[][]{{0, 0}, {0, 9}};
        o = new int[]{3, 1};
        k = 1;
        run1(p, o, k);
        run2(p, o, k);
    }

    static int getDis(int[] i1, int[] i2) {
        return (int) (Math.pow(i1[0] - i2[0], 2) + Math.pow(i1[1] - i2[1], 2));
    }

    static void run1(int[][] p, int[] o, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((i1, i2) -> {
            int diff = getDis(i2, o) - getDis(i1, o);
            if (diff != 0) {
                return diff;
            } else if (i1[0] != i2[0]) {
                return i2[0] - i1[0];
            } else {
                return i2[1] - i1[1];
            }
        });
        for (int[] i : p) {
            maxHeap.offer(i);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[][] res = new int[k][2];
        while (!maxHeap.isEmpty()) {
            res[--k] = maxHeap.poll();
        }
        Arrays.stream(res).forEach(i -> System.out.print(String.format("%d, %d", i[0], i[1])));
        System.out.println();
    }

    static void run2(int[][] p, int[] o, int k) {
        Set<int[]> set = new TreeSet<>((i1, i2) -> {
            int diff = getDis(i1, o) - getDis(i2, o);
            if (diff != 0) {
                return diff;
            } else if (i1[0] != i2[0]) {
                return i1[0] - i2[0];
            } else {
                return i1[1] - i2[1];
            }
        });
        for (int[] i : p) {
            set.add(i);
        }
        int[][] res = new int[k][2];
        int j = 0;
        for (int[] i : set) {
            res[j++] = i;
            if (j == k) break;
        }
        Arrays.stream(res).forEach(i -> System.out.print(String.format("%d, %d", i[0], i[1])));
        System.out.println();
    }
}
