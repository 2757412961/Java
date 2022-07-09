package edu.zju.zjh.offer;

/**
 * @author: zjh
 * @date : 2022/4/24 16:34
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0063 {

    private class S1 {

        public int maxProfit(int[] prices) {
            int len = prices.length;
            if (len == 0) return 0;
            int[][][] dp = new int[len + 1][1 + 1][2];
            dp[0][0][1] = Integer.MIN_VALUE;
            dp[0][1][1] = Integer.MIN_VALUE;

            for (int i = 1; i <= len; i++) {
                dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i - 1]);
                dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i - 1]);
            }

            return dp[len][1][0];
        }

    }

    private class S2 {

        public int maxProfit(int[] prices) {
            if (prices.length == 0) return 0;
            int min = prices[0], res = 0;

            for (int i = 1; i < prices.length; i++) {
                if (min > prices[i]) {
                    min = prices[i];
                }
                if (res < prices[i] - min) {
                    res = prices[i] - min;
                }
            }

            return res;
        }

    }

}
