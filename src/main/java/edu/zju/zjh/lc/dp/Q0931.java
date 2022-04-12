package edu.zju.zjh.lc.dp;

/**
 * @author: zjh
 * @date : 2022/4/11 下午 03:49
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0931 {

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
