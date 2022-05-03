package edu.zju.zjh.lc.dp.games;

/**
 * @author: zjh
 * @date : 2022/5/1 上午 11:33
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0064 {

    public int minPathSum(int[][] grid) {
        if (grid.length <= 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 2; i <= m; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        for (int i = 2; i <= n; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = grid[i - 1][j - 1] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m][n];
    }

}
