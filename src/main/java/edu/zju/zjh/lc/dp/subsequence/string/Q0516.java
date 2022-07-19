package edu.zju.zjh.lc.dp.subsequence.string;

/**
 * @author: zjh
 * @date : 2022/4/13 下午 04:46
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0516 {

    private class S1 {

        public int longestPalindromeSubseq(String s) {
            int n = s.length();
            char[] cs = s.toCharArray();
            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                dp[i][i] = 1;
            }

            for (int i = n - 1; i >= 0; i--) {
                for (int j = i + 1; j < n; j++) {
                    if (cs[i] == cs[j]) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }

            return dp[0][n - 1];
        }

    }

    /**
     * 二刷：递归
     * 执行耗时:31 ms,击败了76.49% 的Java用户
     * 内存消耗:51.3 MB,击败了5.10% 的Java用户
     */
    private class S2 {

        private int ans = 0;
        private int[][] memo;

        public int max(int x, int y, int z) {
            return Math.max(Math.max(x, y), z);
        }

        public int dp(char[] chars, int i, int j) {
            if (i > j) return 0;
            if (i == j) return 1;
            if (memo[i][j] != -1) return memo[i][j];

            int res = 0;
            if (chars[i] == chars[j]) {
                res = 2 + dp(chars, i + 1, j - 1);
            } else {
                res = max(dp(chars, i + 1, j - 1), dp(chars, i + 1, j), dp(chars, i, j - 1));
            }

            memo[i][j] = res;
            ans = Math.max(ans, res);
            return res;
        }

        public int longestPalindromeSubseq(String s) {
            int n = s.length();
            char[] chars = s.toCharArray();
            memo = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    memo[i][j] = -1;
                }
            }

            dp(chars, 0, n - 1);
            return ans;
        }

    }

    /**
     * 二刷：动态规划
     * 执行耗时:26 ms,击败了85.40% 的Java用户
     * 内存消耗:50.7 MB,击败了27.89% 的Java用户
     */
    private class S3 {

        public int max(int x, int y, int z) {
            return Math.max(Math.max(x, y), z);
        }

        public int longestPalindromeSubseq(String s) {
            int n = s.length();
            char[] chars = s.toCharArray();
            int res = 1;
            int[][] dp = new int[n][n];

            for (int i = 0; i < n; i++) {
                dp[i][i] = 1;
            }

            for (int i = n - 1; i >= 0; i--) {
                for (int j = i + 1; j < n; j++) {
                    if (chars[i] == chars[j]) {
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = max(dp[i][j - 1], dp[i + 1][j], dp[i + 1][j - 1]);
                    }
                    res = Math.max(res, dp[i][j]);
                }
            }

            return res;
        }

    }

}
