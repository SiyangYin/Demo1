package com.example.springplayground.demo;

public class JZ433 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][][] f;
    static int[][] rank;
    static int cnt;

    public static void main(String[] args) {
        int[][] a = {{1, 1, 0, 0, 0}, {0, 1, 0, 0, 1}, {0, 0, 0, 1, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}};
        run(a);
    }

    static void run(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        f = new int[m][n][2];
        rank = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1) {
                    f[i][j] = new int[]{i, j};
                    cnt++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1) {
                    unionFind(a, new int[]{i, j});
                }
            }
        }
        System.out.println(cnt);
    }

    static void unionFind(int[][] a, int[] u) {
        int m = a.length;
        int n = a[0].length;
        for (int k = 0; k < 3; k++) {
            int x = u[0] + dx[k];
            int y = u[1] + dy[k];
            if (0 <= x && x < m && 0 <= y && y < n && a[x][y] == 1) {
                union(u, new int[]{x, y});
            }
        }
    }

    static void union(int[] u, int[] v) {
        int[] rootU = find(u);
        int[] rootV = find(v);
        if (rootU[0] != rootV[0] || rootU[1] != rootV[1]) {
            int rankU = rank[u[0]][u[1]];
            int rankV = rank[v[0]][v[1]];
            if (rankU < rankV) {
                f[rootU[0]][rootU[1]] = rootV;
            } else if (rankU > rankV) {
                f[rootV[0]][rootV[1]] = rootU;
            } else {
                f[rootU[0]][rootU[1]] = rootV;
                rank[rootV[0]][rootV[1]]++;
            }
            cnt--;
        }
    }

    static int[] find(int[] u) {
        if (f[u[0]][u[1]][0] == u[0] && f[u[0]][u[1]][1] == u[1]) {
            return u;
        }
        return f[u[0]][u[1]] = find(f[u[0]][u[1]]);
    }
}
