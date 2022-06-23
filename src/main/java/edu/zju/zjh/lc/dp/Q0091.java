package edu.zju.zjh.lc.dp;

/**
 * @author: zjh
 * @date : 2022/6/23 下午 02:05
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0091 {

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.9 MB,击败了18.76% 的Java用户
     */
    private class S1 {

        public int numDecodings(String s) {
            int n = s.length();
            int[] dp = new int[n + 1];

            dp[0] = 1;
            dp[1] = s.charAt(0) == '0' ? 0 : 1;
            for (int i = 2; i <= n; i++) {
                char a = s.charAt(i - 2);
                char b = s.charAt(i - 1);

                if ('1' <= b && b <= '9') {
                    dp[i] += dp[i - 1];
                }
                if (a == '1' || (a == '2' && ('0' <= b && b <= '6'))) {
                    dp[i] += dp[i - 2];
                }
            }

            return dp[n];
        }

    }

}
