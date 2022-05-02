package edu.zju.zjh.lc.dp.games;

/**
 * @author: zjh
 * @date : 2022/5/2 下午 03:07
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0174 {

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m - 1; i++) {
            dp[i][n] = 10000000;
        }
        for (int i = 0; i < n - 1; i++) {
            dp[m][i] = 10000000;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int dpi1j = dp[i + 1][j] - dungeon[i][j];
                int dpij1 = dp[i][j + 1] - dungeon[i][j];
                if (dpi1j <= 0 || dpij1 <= 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(dpi1j, dpij1);
                }
            }
        }

        return dp[0][0] + 1;
    }

}
