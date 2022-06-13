package edu.zju.zjh.lc.dp;

/**
 * @author: zjh
 * @date : 2022/3/10 9:52
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0070 {

    public class S1 {

        public int climbStairs(int n) {
            if (n <= 1) return 1;
            int dp0 = 1, dp1 = 1, dp2 = 2;

            for (int i = 2; i <= n; i++) {
                dp2 = dp1 + dp0;
                dp0 = dp1;
                dp1 = dp2;
            }

            return dp2;
        }

    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.7 MB,击败了5.49% 的Java用户
     */
    private class S2 {

        public int climbStairs(int n) {
            int last = 1, prev = 1, cur = 1;

            for (int i = 1; i < n; i++) {
                cur = prev + last;
                last = prev;
                prev = cur;
            }

            return cur;
        }

    }

}
