package com.example.springplayground.demo;

public class JZ433_2 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] f;
    static int[] rank;
    static int cnt;

    public static void main(String[] args) {
        int[][] a = {{1, 1, 0, 0, 0}, {0, 1, 0, 0, 1}, {0, 0, 0, 1, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}};
        run(a);
    }

    static void run(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        f = new int[m * n];
        rank = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1) {
                    f[i * m + j] = i * m + j;
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
                union(u[0] * m + u[1], x * m + y);
            }
        }
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            int rankA = rank[a];
            int rankB = rank[b];
            if (rankA < rankB) {
                f[rootA] = rootB;
            } else if (rankB < rankA) {
                f[rootB] = rootA;
            } else {
                f[rootA] = rootB;
                rank[rootB]++;
            }
            cnt--;
        }
    }

    static int find(int x) {
        if (f[x] == x) {
            return x;
        }
        return f[x] = find(f[x]);
    }
}
