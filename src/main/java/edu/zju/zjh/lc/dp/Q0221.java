package edu.zju.zjh.lc.dp;

/**
 * @author: zjh
 * @date : 2022/7/13 21:34
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0221 {

    /**
     * 方法一：暴力法
     */
    private class S1 {

        class Solution {
            public int maximalSquare(char[][] matrix) {
                int maxSide = 0;
                if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                    return maxSide;
                }
                int rows = matrix.length, columns = matrix[0].length;
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        if (matrix[i][j] == '1') {
                            // 遇到一个 1 作为正方形的左上角
                            maxSide = Math.max(maxSide, 1);
                            // 计算可能的最大正方形边长
                            int currentMaxSide = Math.min(rows - i, columns - j);
                            for (int k = 1; k < currentMaxSide; k++) {
                                // 判断新增的一行一列是否均为 1
                                boolean flag = true;
                                if (matrix[i + k][j + k] == '0') {
                                    break;
                                }
                                for (int m = 0; m < k; m++) {
                                    if (matrix[i + k][j + m] == '0' || matrix[i + m][j + k] == '0') {
                                        flag = false;
                                        break;
                                    }
                                }
                                if (flag) {
                                    maxSide = Math.max(maxSide, k + 1);
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                }
                int maxSquare = maxSide * maxSide;
                return maxSquare;
            }
        }

    }

    /**
     * 方法二：动态规划
     * 执行耗时:5 ms,击败了95.06% 的Java用户
     * 内存消耗:53.5 MB,击败了34.74% 的Java用户
     */
    private class S2 {

        public int min(int x, int y, int z) {
            return Math.min(Math.min(x, y), z);
        }

        public int maximalSquare(char[][] matrix) {
            int res = 0;
            int m = matrix.length, n = matrix[0].length;
            int[][] dp = new int[m + 1][n + 1];

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (matrix[i - 1][j - 1] == '1') {
                        dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                        res = Math.max(res, dp[i][j]);
                    }
                }
            }

            return res * res;
        }

    }

}
