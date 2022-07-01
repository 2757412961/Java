package edu.zju.zjh.offer;

/**
 * @author: zjh
 * @date : 2022/4/14 上午 10:35
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0043 {

    /**
     * 动态规划
     * Memory Limit Exceeded
     */
    private class S0 {

        public int countDigitOne(int n) {
            if (n < 1) return 0;
            int res = 0;
            int[] dp = new int[n + 1];
            dp[1] = 1;

            for (int i = 1; i <= n; i++) {
                dp[i] = dp[i / 10] + dp[i % 10];
                res += dp[i];
            }

            return res;
        }

    }

    /**
     * 方法一：枚举每一数位上 1 的个数
     */
    private class S1 {

        public int countDigitOne(int n) {
            int res = 0;
            int base = 1, number = 0, prev = n, next = 0;

            while (n >= base) {
                number = prev % 10;
                prev /= 10;
                if (number == 0) {
                    res = res + prev * base;
                } else if (number == 1) {
                    res = res + prev * base + n % base + 1;
                } else if (number > 1) {
                    res = res + (prev + 1) * base;
                }
                base = base * 10;
            }

            return res;
        }

    }

    /**
     * 二刷
     * 方法一：枚举每一数位上 1 的个数
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38 MB,击败了71.59% 的Java用户
     */
    private class S2 {

        public int countDigitOne(int n) {
            int res = 0, prev = n, number = -1;
            long base = 1;

            while (n >= base) {
                number = prev % 10;
                prev /= 10;

                if (number == 0) {
                    res += prev * base;
                } else if (number == 1) {
                    res += prev * base + (int) (n % base) + 1;
                } else if (number > 1) {
                    res += (prev + 1) * base;
                }

                base *= 10;
            }

            return res;
        }

    }

}
