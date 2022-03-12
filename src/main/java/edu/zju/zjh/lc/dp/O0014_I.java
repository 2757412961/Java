package edu.zju.zjh.lc.dp;

/**
 * @author: zjh
 * @date : 2022/3/12 11:41
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0014_I {

    public int cuttingRope(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= n; i++) {
            for (int j = i / 2; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] * dp[j]);
            }
        }

        return dp[n];
    }

}
