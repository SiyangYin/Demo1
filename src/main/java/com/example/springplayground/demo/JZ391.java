package com.example.springplayground.demo;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class JZ391 {

    public static void main(String[] args) {
        int[][] a = {{1, 10}, {2, 3}, {5, 8}, {4, 7}};
        run(a);
        a = new int[][]{{1, 2}, {2, 3}, {3, 4}};
        run(a);
    }

    static void run(int[][] a) {
        Set<int[]> set = new TreeSet<>((i1, i2) -> i1[0] != i2[0] ? i1[0] - i2[0] : i1[1] - i2[1]);
        int max = 0, cnt = 0;
        for (int[] i : a) {
            set.add(new int[]{i[0], 1});
            set.add(new int[]{i[1], -1});
        }
        for (int[] i : set) {
            cnt += i[1];
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }
}
