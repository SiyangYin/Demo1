package com.example.springplayground.demo;

import java.util.ArrayDeque;
import java.util.Deque;

public class CORC1738_1 {

    static int[] fx = {1, -1, 0, 0};
    static int[] fy = {0, 0, 1, -1};

    public static void main(String[] args) {
        char[][] grid = {{'#', '#', '.'}, {'.', '.', '.'}, {'.', '#', '.'}, {'.', '#', '.'}};
        run1(grid);
        run2(grid);
    }

    static int run1(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dist = new int[n][m][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    dist[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        dist[n - 1][m - 1][3] = 0;
        Deque<int[]> dq = new ArrayDeque<>();
        dq.push(new int[]{n - 1, m - 1, 3});
        while (!dq.isEmpty()) {
            int[] i = dq.pop();
            int x = i[0];
            int y = i[1];
            int dir = i[2];
            int d = dist[x][y][dir];
            int nx = x + fx[dir];
            int ny = y + fy[dir];
            if (0 <= nx && nx < n && 0 <= ny && ny < m && d < dist[nx][ny][dir]) {
                dist[nx][ny][dir] = d;
                dq.push(new int[]{nx, ny, dir});
            }
            if (grid[x][y] == '#') {
                for (int j = 0; j < 4; j++) {
                    if (j != dir && d + 1 < dist[x][y][j]) {
                        dist[x][y][j] = d + 1;
                        dq.offer(new int[]{x, y, j});
                    }
                }
            }
        }
        if (dist[0][0][3] == Integer.MAX_VALUE) {
            System.out.println(-1);
            return -1;
        }
        System.out.println(dist[0][0][3]);
        return dist[0][0][3];
    }

    static int run2(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dist = new int[n][m][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    dist[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        dist[0][0][2] = 0;
        Deque<int[]> dq = new ArrayDeque<>();
        dq.push(new int[]{0, 0, 2});
        while (!dq.isEmpty()) {
            int[] i = dq.pop();
            int x = i[0];
            int y = i[1];
            int dir = i[2];
            int d = dist[x][y][dir];
            int nx = x + fx[dir];
            int ny = y + fy[dir];
            if (0 <= nx && nx < n && 0 <= ny && ny < m && d < dist[nx][ny][dir]) {
                dist[nx][ny][dir] = d;
                dq.push(new int[]{nx, ny, dir});
            }
            if (grid[x][y] == '#') {
                for (int j = 0; j < 4; j++) {
                    if (j != dir && d + 1 < dist[x][y][j]) {
                        dist[x][y][j] = d + 1;
                        dq.offer(new int[]{x, y, j});
                    }
                }
            }
        }
        if (dist[n - 1][m - 1][2] == Integer.MAX_VALUE) {
            System.out.println(-1);
            return -1;
        }
        System.out.println(dist[n - 1][m - 1][2]);
        return dist[n - 1][m - 1][2];
    }
}
