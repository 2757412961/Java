package edu.zju.zjh.lc.dp.bag;

/**
 * @author: zjh
 * @date : 2022/4/13 下午 07:49
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0416 {

    /**
     * 方法一：动态规划 转换为 「0 - 1」 背包问题
     */
    private class S1 {

        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            if (sum % 2 == 1) return false;
            int m = nums.length, n = sum / 2;
            boolean[][] dp = new boolean[m + 1][n + 1];

            for (int i = 0; i <= m; i++) {
                dp[i][0] = true;
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (j >= nums[i - 1]) {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            return dp[m][n];
        }

    }

    /**
     * 方法一：动态规划 转换为 「0 - 1」 背包问题
     * 执行耗时:51 ms,击败了5.75% 的Java用户
     * 内存消耗:42.2 MB,击败了36.04% 的Java用户
     */
    private class S2 {

        public boolean canPartition(int[] nums) {
            int n = nums.length, sum = 0;
            for (int i = 0; i < n; i++) {
                sum += nums[i];
            }

            if (sum % 2 == 1) return false;

            int target = sum / 2;
            boolean[][] dp = new boolean[target + 1][n + 1];

            for (int i = 0; i <= n; i++) {
                dp[0][i] = true;
            }
            for (int i = 1; i <= target; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i >= nums[j - 1]) {
                        dp[i][j] = dp[i][j - 1] || dp[i - nums[j - 1]][j - 1];
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }

            return dp[target][n];
        }

    }

}
