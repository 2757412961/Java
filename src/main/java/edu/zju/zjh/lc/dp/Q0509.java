package edu.zju.zjh.lc.dp;

/**
 * @author: zjh
 * @date : 2022/2/21 16:54
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0509 {

    public int fib(int n) {
        if (n < 2) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

}
