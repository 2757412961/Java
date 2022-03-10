package edu.zju.zjh.lc.dp;

/**
 * @author: zjh
 * @date : 2022/3/10 9:52
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0070 {

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
