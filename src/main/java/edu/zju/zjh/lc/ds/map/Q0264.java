package edu.zju.zjh.lc.ds.map;

/**
 * @author: zjh
 * @date : 2022/7/10 20:10
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0264 {

    /**
     * 方法二：动态规划
     * 执行耗时:1 ms,击败了99.75% 的Java用户
     * 内存消耗:39.8 MB,击败了62.45% 的Java用户
     */
    private class S1 {

        public int min(int x, int y, int z) {
            return Math.min(Math.min(x, y), z);
        }

        public int nthUglyNumber(int n) {
            int[] dp = new int[n + 1];
            int p2 = 1, p3 = 1, p5 = 1;

            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                int dp2 = dp[p2] * 2;
                int dp3 = dp[p3] * 3;
                int dp5 = dp[p5] * 5;
                int min = min(dp2, dp3, dp5);
                dp[i] = min;

                if (min == dp2) p2++;
                if (min == dp3) p3++;
                if (min == dp5) p5++;
            }

            return dp[n];
        }

    }

}
