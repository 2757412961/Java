package edu.zju.zjh.lc.dp;

/**
 * @author: zjh
 * @date : 2022/3/11 16:44
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0010_I {

    public int fib(int n) {
        if (n < 2) return n;
        int dp0 = 0, dp1 = 1, dp2 = 0;

        for (int i = 2; i <= n; i++) {
            dp2 = dp1 + dp0;
            if (i >= 40) {
                dp2 %= 1000000007;
            }
            dp0 = dp1;
            dp1 = dp2;
        }

        return dp2;
    }

}
