package edu.zju.zjh.topk.zijie.internship;

import java.util.Scanner;

/**
 * @author: zjh
 * @date : 2022/4/24 下午 10:03
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q001 {

    public static int sum = 0;

    public static int[][] dirs = new int[][]{
            new int[]{0, 1},
            new int[]{0, -1},
            new int[]{1, 0},
            new int[]{-1, 0},
    };

    public static boolean inBox(int[][] arr, int i, int j) {
        if (i < 0 || i >= arr.length) return false;
        if (j < 0 || j >= arr[0].length) return false;

        return true;
    }

    public static int dfs(int[][] arr, boolean[][] used, int i, int j) {
        if (!inBox(arr, i, j)) return 0;
        if (used[i][j]) return 0;
        used[i][j] = true;

        int res = 1;
        for (int d = 0; d < dirs.length; d++) {
            int x = i + dirs[d][0];
            int y = j + dirs[d][1];
            res += dfs(arr, used, x, y);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        boolean[][] used = new boolean[m][n];
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 1) used[i][j] = true;
            }
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!used[i][j]) {
                    res = Math.max(res, dfs(arr, used, i, j));
                }
            }
        }

        System.out.println(res);
    }

}
