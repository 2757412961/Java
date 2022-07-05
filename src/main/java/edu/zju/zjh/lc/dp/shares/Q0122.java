package edu.zju.zjh.lc.dp.shares;

/**
 * @author: zjh
 * @date : 2022/4/24 20:31
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0122 {

    /**
     * 方法一：动态规划
     * 执行耗时:1 ms,击败了81.34% 的Java用户
     * 内存消耗:41.6 MB,击败了12.78% 的Java用户
     */
    private class S1 {

        public int maxProfit(int[] prices) {
            if (prices.length == 0) return 0;
            int[][] dp = new int[prices.length + 1][2];
            dp[0][1] = Integer.MIN_VALUE;

            for (int i = 1; i < dp.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);
            }

            return dp[prices.length][0];
        }

    }

    /**
     * 方法二：贪心
     * 执行耗时:1 ms,击败了81.34% 的Java用户
     * 内存消耗:41.5 MB,击败了19.04% 的Java用户
     */
    private class S2 {

        public int maxProfit(int[] prices) {
            int res = 0;

            for (int i = 1; i < prices.length; i++) {
                res += Math.max(prices[i] - prices[i - 1], 0);
            }

            return res;
        }

    }

    /**
     * 二刷
     * 执行耗时:1 ms,击败了81.34% 的Java用户
     * 内存消耗:41.2 MB,击败了69.05% 的Java用户
     */
    private class S3 {

        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[][] dp = new int[n + 1][2];

            dp[0][1] = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            }

            return dp[n][0];
        }

    }

}
