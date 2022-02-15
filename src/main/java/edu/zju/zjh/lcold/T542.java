package edu.zju.zjh.lcold;

import java.util.LinkedList;
import java.util.Queue;

public class T542 {
    public int[][] updateMatrix_OutTime(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] res = new int[m][n];
        if (m <= 0 || n <= 0) {
            return null;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                int[][] used = new int[m][n];
                Queue<Integer[]> queue = new LinkedList<>();
                Queue<Integer> depths = new LinkedList<>();
                queue.add(new Integer[]{i, j});
                depths.add(0);
                while (!queue.isEmpty()) {
                    Integer[] top = queue.poll();
                    int x = top[0];
                    int y = top[1];
                    int depth = depths.poll();

                    if (x < 0 || x >= m || y < 0 || y >= n) {
                        continue;
                    }
                    if (matrix[x][y] == 0) {
                        res[i][j] = depth;
                        break;
                    }
                    if (used[x][y] != 0) {
                        continue;
                    }
                    used[x][y] = 1;

                    queue.add(new Integer[]{x + 1, y});
                    depths.add(depth + 1);
                    queue.add(new Integer[]{x - 1, y});
                    depths.add(depth + 1);
                    queue.add(new Integer[]{x, y + 1});
                    depths.add(depth + 1);
                    queue.add(new Integer[]{x, y - 1});
                    depths.add(depth + 1);
                }
            }
        }


        return res;
    }

    public int[][] updateMatrix_BFS(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        int[][] used = new int[m][n];
        Queue<Integer[]> queue = new LinkedList<>();
        Queue<Integer> depths = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    res[i][j] = 0;
                    queue.add(new Integer[]{i, j});
                    depths.add(0);
                }
            }
        }

        while (!queue.isEmpty()) {
            Integer[] top = queue.poll();
            int x = top[0];
            int y = top[1];
            int depth = depths.poll();
            if (x < 0 || x >= m || y < 0 || y >= n || used[x][y] == 1) {
                continue;
            }
            used[x][y] = 1;
            res[x][y] = depth;

            queue.add(new Integer[]{x + 1, y});
            depths.add(depth + 1);
            queue.add(new Integer[]{x - 1, y});
            depths.add(depth + 1);
            queue.add(new Integer[]{x, y + 1});
            depths.add(depth + 1);
            queue.add(new Integer[]{x, y - 1});
            depths.add(depth + 1);
        }

        return res;
    }

    public int[][] updateMatrix_DP(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    res[i][j] = 0;
                } else {
                    res[i][j] = 99999;
                }
            }
        }


        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = Math.min(res[i][j], 1 + res[i][j - 1]);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = n - 2; j >= 0; j--) {
                res[i][j] = Math.min(res[i][j], 1 + res[i][j + 1]);
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = Math.min(res[i][j], 1 + res[i - 1][j]);
            }
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                res[i][j] = Math.min(res[i][j], 1 + res[i + 1][j]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        T542 t542 = new T542();
        t542.updateMatrix_DP(matrix);
        t542.updateMatrix_BFS(matrix);
        t542.updateMatrix_OutTime(matrix);
    }
}
