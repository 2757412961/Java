package edu.zju.zjh.lc.math;

/**
 * @author: zjh
 * @date : 2022/6/1 9:06
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0343 {

    /**
     * 方法一：动态规划
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.2 MB,击败了54.31% 的Java用户
     */
    private class S1 {

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

    /**
     * 方法三：数学
     * 归纳证明法
     * 第一步：证明最优的拆分方案中不会出现大于 4 的整数。
     * 第二步：证明最优的拆分方案中可以不出现整数 4。
     * 第三步：证明当 n≥5 时，最优的拆分方案中不会出现整数 1。
     * 第四步：证明当 5n≥5 时，最优的拆分方案中 2 的个数不会超过 3 个。
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38 MB,击败了88.22% 的Java用户
     */
    private class S2 {

        public int integerBreak(int n) {
            if (n == 2) return 1;
            if (n == 3) return 2;
            if (n == 4) return 4;
            int res = 1;

            while (n > 4) {
                res *= 3;
                n -= 3;
            }

            return res * n;
        }

    }

}
