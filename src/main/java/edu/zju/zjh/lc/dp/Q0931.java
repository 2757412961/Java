package edu.zju.zjh.lc.dp;

/**
 * @author: zjh
 * @date : 2022/4/11 下午 03:49
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0931 {

    /**
     * 假的动态规划？
     * 执行耗时:3 ms,击败了71.80% 的Java用户
     * 内存消耗:41.8 MB,击败了63.00% 的Java用户
     */
    private class S1 {

        private int[] dirs = new int[]{-1, 0, 1};

        public boolean inCol(int n, int idx) {
            if (idx < 0 || idx >= n) return false;
            return true;
        }

        public int minFallingPathSum(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length, res = 999999;
            int[][] dp = new int[m + 1][n];

            // 1. init
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = 999999;
                    }
                }
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int d = 0; d < dirs.length; d++) {
                        if (inCol(n, j + dirs[d])) {
                            dp[i][j] = Math.min(
                                    dp[i][j],
                                    dp[i - 1][j + dirs[d]] + matrix[i - 1][j]
                            );
                        }
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                res = Math.min(res, dp[m][j]);
            }

            return res;
        }

    }

    /**
     * 动态规划
     * 执行耗时:4 ms,击败了67.25% 的Java用户
     * 内存消耗:41.7 MB,击败了76.79% 的Java用户
     */
    private class S2 {

        public int minFallingPathSum(int[][] matrix) {
            int[][] dp = new int[matrix.length + 1][matrix.length + 2];
            int n = dp.length;
            // base case
            for (int i = 1; i < n; i++) {
                dp[i][0] = Integer.MAX_VALUE;
                dp[i][n] = Integer.MAX_VALUE;
            }
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = matrix[i - 1][j - 1] + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]));
                }
            }
            // 所以可行解都在 dp[n - 1][1...n-1] 中
            int ans = Integer.MAX_VALUE;
            for (int i = 1; i < n; i++) ans = Math.min(ans, dp[n - 1][i]);
            return ans;
        }

    }

}
