package edu.zju.zjh.lc.offer;

/**
 * @author: zjh
 * @date : 2022/4/14 下午 05:13
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0047 {

    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }

        return dp[m][n];
    }

}
