package edu.zju.zjh.lc.dp;

/**
 * @author: zjh
 * @date : 2022/4/13 下午 04:46
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q1312 {

    public int minInsertions(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (cs[i] == cs[j]) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        return dp[0][n - 1];
    }

}
