package edu.zju.zjh.lc.dp.shares;

/**
 * @author: zjh
 * @date : 2022/4/24 20:31
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0188 {

    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) return 0;

        int[][][] dp = new int[prices.length + 1][k + 1][2];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i][1] = Integer.MIN_VALUE;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i - 1]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i - 1]);
            }
        }

        return dp[prices.length][k][0];
    }

}
