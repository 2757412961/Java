package edu.zju.zjh.lc.math;

/**
 * @author: zjh
 * @date : 2022/6/1 9:06
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0343 {

    /**
     * 动态规划
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.2 MB,击败了54.31% 的Java用户
     */
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int[] dp = new int[Math.max(n, 3) + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= n; i++) {
            int end = i / 2 + 1;
            for (int j = 1; j < end; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] * dp[j]);
            }
        }

        return dp[n];
    }

}
