package edu.zju.zjh.lc.dp.shares;

/**
 * @author: zjh
 * @date : 2022/4/24 20:31
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0714 {

    /**
     * 方法一：动态规划
     */
    private class S1 {

        public int maxProfit(int[] prices, int fee) {
            if (prices.length == 0) return 0;
            int[][] dp = new int[prices.length + 1][2];
            dp[0][1] = Integer.MIN_VALUE;

            for (int i = 1; i < dp.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1] - fee);
            }

            return dp[prices.length][0];
        }

    }

    /**
     * 方法二：贪心算法
     */

    /**
     * 二刷：动态规划
     * 执行耗时:19 ms,击败了20.52% 的Java用户
     * 内存消耗:48.7 MB,击败了84.15% 的Java用户
     */
    private class S2 {

        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            int[][] dp = new int[n + 1][2];

            dp[0][0] = 0;
            dp[0][1] = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1] - fee);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);
            }

            return dp[n][0];
        }

    }

}
