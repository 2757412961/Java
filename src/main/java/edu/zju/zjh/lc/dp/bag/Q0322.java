package edu.zju.zjh.lc.dp.bag;

/**
 * @author: zjh
 * @date : 2022/4/10 下午 05:14
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0322 {

    /**
     * 方法一：动态规划
     */
    private class S1 {

        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];

            for (int i = 1; i <= amount; i++) {
                dp[i] = amount + 1;
            }

            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= amount) {
                    dp[coins[j]] = 1;
                }
            }

            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (i - coins[j] > 0) {
                        dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                    }
                }
            }

            return dp[amount] > amount ? -1 : dp[amount];
        }

    }

    /**
     * 二刷
     * 执行耗时:11 ms,击败了86.95% 的Java用户
     * 内存消耗:41.2 MB,击败了29.70% 的Java用户
     */
    private class S2 {

        public static final int LIMIT = 100000;

        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];

            for (int i = 1; i <= amount; i++) {
                dp[i] = LIMIT;
                for (int j = 0; j < coins.length; j++) {
                    if (i - coins[j] >= 0) {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }

            return dp[amount] == LIMIT ? -1 : dp[amount];
        }

    }

}
