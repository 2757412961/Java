package edu.zju.zjh.lc.dp;

/**
 * @author: zjh
 * @date : 2022/6/2 20:44
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0062 {

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.5 MB,击败了11.14% 的Java用户
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        dp[0][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m][n];
    }

}
