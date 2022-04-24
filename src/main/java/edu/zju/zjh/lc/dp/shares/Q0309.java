package edu.zju.zjh.lc.dp.shares;

/**
 * @author: zjh
 * @date : 2022/4/24 20:56
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0309 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[][] dp = new int[prices.length + 1][2];
        dp[0][1] = Integer.MIN_VALUE;

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            if (i >= 2) {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i - 1]);
            } else {
                dp[i][1] = Math.max(dp[i - 1][1],  - prices[i - 1]);
            }
        }

        return dp[prices.length][0];
    }

}
