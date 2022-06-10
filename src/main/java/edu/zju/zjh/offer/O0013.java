package edu.zju.zjh.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: zjh
 * @date : 2022/3/3 14:58
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0013 {

    private int[] calDigitSum(int n) {
        if (n == 0) return new int[]{0};
        int[] digitSum = new int[n + 1];
        int sum = 0;

        digitSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            digitSum[i] = digitSum[i / 10] + i % 10;
        }

        return digitSum;
    }

    private int[] dirsx = new int[]{0, 1};
    private int[] dirsy = new int[]{1, 0};

    private boolean inBox(int m, int n, int i, int j) {
        if (i < 0 || i >= m) return false;
        if (j < 0 || j >= n) return false;
        return true;
    }

    public int movingCount(int m, int n, int k) {
        int res = 1;
        int[][] vis = new int[m][n];
        int[] digitSum = calDigitSum(Math.max(m, n));
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (digitSum[i] + digitSum[j] > k) {
                    vis[i][j] = 1;
                }
            }
        }

        queue.offer(new int[]{0, 0});
        vis[0][0] = 1;
        while (queue.size() > 0) {
            int[] pos = queue.poll();

            for (int i = 0; i < dirsx.length; i++) {
                int x = pos[0] + dirsx[i];
                int y = pos[1] + dirsy[i];
                if (inBox(m, n, x, y)) {
                    if (vis[x][y] == 0) {
                        res++;
                        queue.offer(new int[]{x, y});
                        vis[x][y] = 1;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new O0013().movingCount(1, 2, 1));
    }

}
