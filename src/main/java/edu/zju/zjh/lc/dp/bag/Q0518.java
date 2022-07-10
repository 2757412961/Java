package edu.zju.zjh.lc.dp.bag;

/**
 * @author: zjh
 * @date : 2022/4/13 下午 08:51
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0518 {

    /**
     * 方法一：动态规划
     * 执行耗时:8 ms,击败了11.10% 的Java用户
     * 内存消耗:45.6 MB,击败了25.51% 的Java用户
     */
    private class S1 {

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

    /**
     * 方法一：动态规划
     * 执行耗时:8 ms,击败了11.10% 的Java用户
     * 内存消耗:45.6 MB,击败了25.51% 的Java用户
     */
    private class S2 {

        public int change(int amount, int[] coins) {
            int count = coins.length;
            int[][] dp = new int[amount + 1][count + 1];

            for (int j = 1; j <= coins.length; j++) {
                dp[0][j] = 1;
            }

            for (int i = 1; i <= amount; i++) {
                for (int j = 1; j <= count; j++) {
                    if (i >= coins[j - 1]) {
                        dp[i][j] = dp[i][j - 1] + dp[i - coins[j - 1]][j];
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }

            return dp[amount][count];
        }

    }

    /**
     * 方法一：动态规划
     * 执行耗时:8 ms,击败了11.28% 的Java用户
     * 内存消耗:45.6 MB,击败了25.85% 的Java用户
     */
    private class S3 {

        public int change(int amount, int[] coins) {
            int[][] dp = new int[amount + 1][coins.length + 1];

            for (int j = 1; j <= coins.length; j++) {
                dp[0][j] = 1;
            }

            for (int i = 1; i <= amount; i++) {
                for (int j = 1; j <= coins.length; j++) {
                    int coin = coins[j - 1];
                    if (i >= coin) {
                        dp[i][j] = dp[i][j - 1] + dp[i - coin][j];
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }

            return dp[amount][coins.length];
        }

    }

}
