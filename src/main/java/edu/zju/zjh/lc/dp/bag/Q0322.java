package edu.zju.zjh.lc.dp.bag;

/**
 * @author: zjh
 * @date : 2022/4/10 下午 05:14
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0322 {

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
