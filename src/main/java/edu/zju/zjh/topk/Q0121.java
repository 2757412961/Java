package edu.zju.zjh.topk;

/**
 * @author: zjh
 * @date : 2022/5/23 9:42
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0121 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        dp[0][1] = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i - 1]);
        }

        return dp[n][0];
    }

}
