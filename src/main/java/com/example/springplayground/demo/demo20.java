package com.example.springplayground.demo;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class demo20 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static void run (int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }
        int step = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] node = q.poll();
                for (int j = 0; j < 4; j++) {
                    int x = node[0] + dx[j];
                    int y = node[1] + dy[j];
                    if (0 <= x && x < m && 0 <= y && y < n && !visited[x][y]) {
                        visited[x][y] = true;
                        grid[x][y] = step;
                        q.offer(new int[]{x, y});
                    }
                }
            }
            step++;
        }
    }

    public static void main(String[] args) {
        int grid[][] = {{-1, -1, -1, -1},
                        {-1, 0, -1, -1},
                        {-1, -1, -1, 0},
                        {0, -1, -1, -1}};
        run(grid);
        Arrays.stream(grid).forEach(i -> {
            Arrays.stream(i).forEach(j -> System.out.print(String.format("%s, ", j)));
            System.out.println();
        });
    }
}
