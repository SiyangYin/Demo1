package com.example.springplayground.demo;

import java.util.*;

public class JZ616 {

    public static void main(String[] args) {
        int n = 4;
        int[][] p = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        run(p, n);
    }

    static void run(int[][] p, int n) {
        List<Integer>[] g = new List[n];
        int[] ind = new int[n];
        for (int[] i : p) {
            ind[i[0]]++;
            if (g[i[1]] == null) {
                g[i[1]] = new ArrayList();
            }
            g[i[1]].add(i[0]);
        }
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < ind.length; i++) {
            if (ind[i] == 0) {
                dq.offer(i);
            }
        }
        int[] res = new int[n];
        int k = 0;
        while (!dq.isEmpty()) {
            int i = dq.pop();
            res[k++] = i;
            if (g[i] == null) continue;
            for (int j : g[i]) {
                ind[j]--;
                if (ind[j] == 0) {
                    dq.offer(j);
                }
            }
        }
        if (k == n) {
            Arrays.stream(res).forEach(i -> System.out.print(String.format("%d, ", i)));
        } else {
            System.out.println(new int[0]);
        }
    }
}
