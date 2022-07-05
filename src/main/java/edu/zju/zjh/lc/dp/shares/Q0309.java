package edu.zju.zjh.lc.dp.shares;

/**
 * @author: zjh
 * @date : 2022/4/24 20:56
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0309 {

    /**
     * 方法一：动态规划
     * 执行耗时:1 ms,击败了77.54% 的Java用户
     * 内存消耗:40.2 MB,击败了5.01% 的Java用户
     */
    private class S1 {

        public int maxProfit(int[] prices) {
            if (prices.length == 0) return 0;
            int[][] dp = new int[prices.length + 1][2];
            dp[0][1] = Integer.MIN_VALUE;

            for (int i = 1; i < dp.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
                if (i >= 2) {
                    dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i - 1]);
                } else {
                    dp[i][1] = Math.max(dp[i - 1][1], -prices[i - 1]);
                }
            }

            return dp[prices.length][0];
        }

    }

    /**
     * 二刷
     * 执行耗时:1 ms,击败了77.54% 的Java用户
     * 内存消耗:39.8 MB,击败了32.24% 的Java用户
     */
    private class S2 {

        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[][] dp = new int[n + 1][2];

            dp[0][1] = Integer.MIN_VALUE;
            dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[0]);
            dp[1][1] = Math.max(dp[0][1], dp[0][0] - prices[0]);
            for (int i = 2; i <= n; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i - 1]);
            }

            return dp[n][0];
        }

    }

}
