package edu.zju.zjh.offer;

import java.util.Arrays;

/**
 * @author: zjh
 * @date : 2022/4/22 10:16
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0060 {

    private class S1 {

        /**
         * 方法一：递归 + 备忘录
         */
        private double[][] memo;

        public double dp(int n, int x) {
            if (n == 1) return 1.0 / 6.0;
            if (memo[n][x] > 0) return memo[n][x];
            double res = 0;

            int min = n - 1, max = 6 * min;
            for (int i = 1; i <= 6; i++) {
                int last = x - i;
                if (min <= last && last <= max) {
                    res += dp(n - 1, last);
                }
            }
            memo[n][x] = res / 6.0;

            return memo[n][x];
        }

        public double[] dicesProbability(int n) {
            int start = n, end = 6 * n + 1;
            double[] res = new double[5 * n + 1];
            memo = new double[n + 1][end];

            int idx = 0;
            while (idx < res.length) {
                res[idx] = dp(n, idx + n);
                idx++;
            }

            return res;
        }

    }

    /**
     * 方法二：动态规划
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:42.1 MB,击败了22.96% 的Java用户
     */
    private class S2 {

        public double[] dicesProbability(int n) {
            int n6 = 6 * n;
            double[][] dp = new double[n + 1][n6 + 1];

            // init
            for (int i = 1; i <= 6; i++) {
                dp[1][i] = 1.0 / 6;
            }

            for (int i = 2; i <= n; i++) {
                int max = i * 6;
                for (int j = i; j <= max; j++) {
                    for (int k = 1; k <= 6; k++) {
                        if (j - k <= 0) break;
                        dp[i][j] += dp[i - 1][j - k] / 6;
                    }
                }
            }

            double[] res = new double[5 * n + 1];
            for (int i = 0; i < res.length; i++) {
                res[i] = dp[n][i + n];
            }

            return res;
        }

    }

    public static void main(String[] args) {
        Arrays.stream(new O0060().new S1().dicesProbability(6)).forEach(System.out::print);
        System.out.println();
        Arrays.stream(new O0060().new S2().dicesProbability(6)).forEach(System.out::print);
    }

}
