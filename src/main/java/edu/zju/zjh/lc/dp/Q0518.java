package edu.zju.zjh.lc.dp;

/**
 * @author: zjh
 * @date : 2022/4/13 下午 08:51
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0518 {

    public int change(int amount, int[] coins) {
        int m = amount, n = coins.length;
        int[][] dp = new int[m + 1][n + 1];

        for (int j = 0; j <= n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (coins[j - 1] > i) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - coins[j - 1]][j];
                }
            }
        }

        return dp[m][n];
    }

}
