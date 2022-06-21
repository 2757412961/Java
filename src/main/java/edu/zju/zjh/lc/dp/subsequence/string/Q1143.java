package edu.zju.zjh.lc.dp.subsequence.string;

/**
 * @author: zjh
 * @date : 2022/4/12 下午 03:58
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q1143 {

    /**
     * 动态规划
     */
    private class S1 {

        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length(), n = text2.length();
            int[][] dp = new int[m + 1][n + 1];

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            return dp[m][n];
        }

    }

    /**
     * 二刷
     * 执行耗时:10 ms,击败了64.16% 的Java用户
     * 内存消耗:45.5 MB,击败了5.14% 的Java用户
     */
    private class S2 {

        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length(), n = text2.length();
            int[][] dp = new int[m + 1][n + 1];

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            return dp[m][n];
        }

    }

}
