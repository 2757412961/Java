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

    /**
     * 方法一：深度优先搜索
     * 执行耗时:3 ms,击败了27.31% 的Java用户
     * 内存消耗:39.3 MB,击败了12.60% 的Java用户
     */
    private class S1 {

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

    }

    /**
     * 方法二：动态规划
     * 执行耗时:1 ms,击败了62.13% 的Java用户
     * 内存消耗:38.4 MB,击败了52.99% 的Java用户
     */
    private class S2 {

        public int calDigitSum(int digit) {
            int sum = 0;
            while (digit > 0) {
                sum += digit % 10;
                digit /= 10;
            }
            return sum;
        }

        public int movingCount(int m, int n, int k) {
            int res = 0;
            int[] row = new int[m];
            int[] col = new int[n];
            boolean[][] reach = new boolean[m + 1][n + 1];

            for (int i = 0; i < m; i++) {
                row[i] = calDigitSum(i);
            }
            for (int i = 0; i < n; i++) {
                col[i] = calDigitSum(i);
            }

            reach[1][0] = true;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (reach[i - 1][j] || reach[i][j - 1]) {
                        if (row[i - 1] + col[j - 1] > k) continue;

                        reach[i][j] = true;
                        res++;
                    }
                }
            }

            return res;
        }

    }

    public static void main(String[] args) {
        System.out.println(new O0013().new S1().movingCount(1, 2, 1));
    }

}
