package edu.zju.zjh.lc.dp;

/**
 * @author: zjh
 * @date : 2022/5/24 10:48
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0279 {

    /**
     * 方法一：动态规划 时间复杂度：O(n*sqrt{n})
     * 执行耗时:43 ms,击败了32.97% 的Java用户
     * 内存消耗:40.7 MB,击败了35.66% 的Java用户
     */
    private class S1 {

        public int numSquares(int n) {
            int[] dp = new int[n + 1];

            for (int i = 1; i * i <= n; i++) {
                dp[i * i] = 1;
            }

            for (int i = 1; i <= n; i++) {
                if (dp[i] == 1) continue;
                dp[i] = i;
                for (int j = 1; j * j < i; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }

            return dp[n];
        }

    }

    /**
     * 二刷
     * 执行耗时:42 ms,击败了46.35% 的Java用户
     * 内存消耗:40.6 MB,击败了59.16% 的Java用户
     */
    private class S2 {

        public int numSquares(int n) {
            int[] dp = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                dp[i] = n;
                for (int j = 1; j * j <= i; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }

            return dp[n];
        }

    }

}
