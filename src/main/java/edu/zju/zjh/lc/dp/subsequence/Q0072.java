package edu.zju.zjh.lc.dp.subsequence;

import java.util.Arrays;

/**
 * @author: zjh
 * @date : 2022/4/12 上午 09:12
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0072 {

    /**
     * 方法一：递归 + 备忘录
     */
    private class S1 {

        private final int INIT = 9999999;
        private int[][] memo;

        public int min(int x, int y, int z) {
            return Math.min(x, Math.min(y, z));
        }

        public int putAndReturn(int i, int j, int val) {
            memo[i][j] = val;
            return val;
        }

        public int dp(String s, int i, String t, int j) {
            if (memo[i][j] != INIT) return memo[i][j];
            if (i == s.length()) return putAndReturn(i, j, t.length() - j);
            if (j == t.length()) return putAndReturn(i, j, s.length() - i);

            if (s.charAt(i) == t.charAt(j)) {
                return putAndReturn(i, j, dp(s, i + 1, t, j + 1));
            } else {
                return putAndReturn(i, j, 1 + min(dp(s, i + 1, t, j + 1), dp(s, i + 1, t, j), dp(s, i, t, j + 1)));
            }
        }

        public int minDistance(String word1, String word2) {
            memo = new int[word1.length() + 1][word2.length() + 1];
            for (int i = 0; i < memo.length; i++) {
                Arrays.fill(memo[i], INIT);
            }

            return dp(word1, 0, word2, 0);
        }

    }

    /**
     * 方法二：规划
     */
    private class S2 {

        public int min(int x, int y, int z) {
            return Math.min(x, Math.min(y, z));
        }

        public int minDistance(String word1, String word2) {
            int m = word1.length(), n = word2.length();
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 0; i < dp.length; i++) {
                dp[i][0] = i;
            }
            for (int j = 0; j < dp[0].length; j++) {
                dp[0][j] = j;
            }

            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[0].length; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = 1 + min(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }

            return dp[m][n];
        }

    }

    /**
     * 二刷
     */
    private class S3 {

        public int minDistance(String word1, String word2) {
            int m = word1.length(), n = word2.length();
            int[][] dp = new int[m + 1][n + 1];

            for (int i = 1; i <= m; i++) {
                dp[i][0] = i;
            }
            for (int j = 0; j <= n; j++) {
                dp[0][j] = j;
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                }
            }

            return dp[m][n];
        }

    }

    public static void main(String[] args) {
        System.out.println(new Q0072().new S1().minDistance("horse", "ros"));
        System.out.println(new Q0072().new S2().minDistance("horse", "ros"));
        System.out.println(new Q0072().new S3().minDistance("horse", "ros"));

        System.out.println(new Q0072().new S1().minDistance("acetylphenylhydrazine", "execution"));
        System.out.println(new Q0072().new S2().minDistance("acetylphenylhydrazine", "execution"));
        System.out.println(new Q0072().new S3().minDistance("acetylphenylhydrazine", "execution"));

        System.out.println(new Q0072().new S1().minDistance("dinitrophenylhydrazine", "acetylphenylhydrazine"));
        System.out.println(new Q0072().new S2().minDistance("dinitrophenylhydrazine", "acetylphenylhydrazine"));
        System.out.println(new Q0072().new S3().minDistance("dinitrophenylhydrazine", "acetylphenylhydrazine"));

        System.out.println(new Q0072().new S1().minDistance("pneumonoultramicroscopicsilicovolcanoconiosis", "stereomicroscopically"));
        System.out.println(new Q0072().new S2().minDistance("pneumonoultramicroscopicsilicovolcanoconiosis", "stereomicroscopically"));
        System.out.println(new Q0072().new S3().minDistance("pneumonoultramicroscopicsilicovolcanoconiosis", "stereomicroscopically"));
    }

}
