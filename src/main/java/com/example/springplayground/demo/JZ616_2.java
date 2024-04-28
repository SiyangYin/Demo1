package com.example.springplayground.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JZ616_2 {

    static List<Integer>[] g;
    static int[] v;
    static int[] res;
    static int cnt;
    static boolean valid = true;

    public static void main(String[] args) {
        int n = 4;
        int[][] p = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        run(p, n);
    }

    static void run(int[][] p, int n) {
        g = new List[n];
        for (int[] i : p) {
            if (g[i[1]] == null) {
                g[i[1]] = new ArrayList<>();
            }
            g[i[1]].add(i[0]);
        }
        v = new int[n];
        res = new int[n];
        cnt = n;
        for (int i = 0; i < n; i++) {
            if (v[i] == 0) {
                dfs(i);
            }
        }
        if (cnt == 0) {
            Arrays.stream(res).forEach(i -> System.out.print(String.format("%d, ", i)));
        } else {
            System.out.println(new int[0]);
        }
    }

    static void dfs(int i) {
        v[i] = 1;
        if (g[i] == null) {
            v[i] = 2;
            res[--cnt] = i;
            return;
        }
        for (int j : g[i]) {
            if (v[j] == 0) {
                v[j] = 1;
                dfs(j);
                if (!valid) return;
            } else if (v[j] == 1) {
                valid = false;
                return;
            }
        }
        v[i] = 2;
        res[--cnt] = i;
    }
}
