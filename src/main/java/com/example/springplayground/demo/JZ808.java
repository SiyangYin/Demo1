package com.example.springplayground.demo;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;

public class JZ808 {

    public static void main(String[] args) {
        int[] r = {10, 20, 30, 40};
        int[][] g = {{1, 3}, {0, 2}, {1}, {0}};
        int s = 0;
        int k = 2;
        run(r, g, s, k);
        r = new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90};
        g = new int[][]{{1, 4, 5}, {0, 2, 3}, {1, 7}, {1, 6, 7}, {0}, {0}, {3}, {2, 3}, {}};
        s = 5;
        k = 3;
        run(r, g, s, k);
    }

    static void run(int[] r, int[][] g, int s, int k) {
        run1(r, g, s, k);
        run2(r, g, s, k);
    }

    static void run1(int[] r, int[][] g, int s, int k) {
        bfs(r, g, s, k);
    }

    static void run2(int[] r, int[][] g, int s, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparing(i-> r[i]));
        boolean[] visited = new boolean[r.length];
        visited[s] = true;
        dfs(r, g, s, k, visited, minHeap);
        int[] res = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            res[i++] = minHeap.poll();
            System.out.print(res[i - 1] + ", ");
        }
        System.out.println();
    }

    static void bfs(int[] r, int[][] g, int s, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparing(i-> r[i]));
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[r.length];
        dq.offer(s);
        visited[s] = true;
        while (!dq.isEmpty()) {
            int i = dq.poll();
            for (int j : g[i]) {
                if (!visited[j]) {
//                    minHeap.offer(j);
//                    if (minHeap.size() > k) {
//                        minHeap.poll();
//                    }
                    visited[j] = true;
                    dq.offer(j);
                    minHeap.offer(j);
                    if (minHeap.size() > k) {
                        minHeap.poll();
                    }
                }
            }
        }
        int[] res = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            res[i++] = minHeap.poll();
            System.out.print(res[i - 1] + ", ");
        }
        System.out.println();
    }

    static void dfs(int[] r, int[][] g, int i, int k, boolean[] visited, PriorityQueue<Integer> minHeap) {
        for (int j : g[i]) {
            if (!visited[j]) {
//                minHeap.offer(j);
//                if (minHeap.size() > k) {
//                    minHeap.poll();
//                }
                visited[j] = true;
                dfs(r, g, j, k, visited, minHeap);
                minHeap.offer(j);
                if (minHeap.size() > k) {
                    minHeap.poll();
                }
            }
        }
    }
}
