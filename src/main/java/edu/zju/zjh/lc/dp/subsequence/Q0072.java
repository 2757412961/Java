package edu.zju.zjh.lc.dp.subsequence;

import java.util.Arrays;

/**
 * @author: zjh
 * @date : 2022/4/12 上午 09:12
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0072 {

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

    public int minDistanceRescur(String word1, String word2) {
        memo = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], INIT);
        }

        return dp(word1, 0, word2, 0);
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

    public static void main(String[] args) {
        System.out.println(new Q0072().minDistanceRescur("horse", "ros"));
        System.out.println(new Q0072().minDistance("horse", "ros"));

        System.out.println(new Q0072().minDistanceRescur("acetylphenylhydrazine", "execution"));
        System.out.println(new Q0072().minDistance("acetylphenylhydrazine", "execution"));

        System.out.println(new Q0072().minDistanceRescur("dinitrophenylhydrazine", "acetylphenylhydrazine"));
        System.out.println(new Q0072().minDistance("dinitrophenylhydrazine", "acetylphenylhydrazine"));

        System.out.println(new Q0072().minDistanceRescur("pneumonoultramicroscopicsilicovolcanoconiosis", "stereomicroscopically"));
        System.out.println(new Q0072().minDistance("pneumonoultramicroscopicsilicovolcanoconiosis", "stereomicroscopically"));
    }

}
