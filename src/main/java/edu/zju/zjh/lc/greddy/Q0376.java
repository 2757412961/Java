package edu.zju.zjh.lc.greddy;

/**
 * @author: zjh
 * @date : 2022/7/12 16:09
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0376 {

    /**
     * 方法一：动态规划
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.2 MB,击败了15.17% 的Java用户
     */
    private class S1 {

        public int wiggleMaxLength(int[] nums) {
            int n = nums.length;
            int[][] dp = new int[n][2];

            dp[0][0] = dp[0][1] = 1;
            for (int i = 1; i < n; i++) {
                if (nums[i] == nums[i - 1]) {
                    dp[i][0] = dp[i - 1][0];
                    dp[i][1] = dp[i - 1][1];
                } else if (nums[i] > nums[i - 1]) {
                    dp[i][0] = dp[i - 1][0];
                    dp[i][1] = Math.max(dp[i - 1][0] + 1, dp[i - 1][1]);
                } else if (nums[i] < nums[i - 1]) {
                    dp[i][0] = Math.max(dp[i - 1][1] + 1, dp[i - 1][0]);
                    dp[i][1] = dp[i - 1][1];
                }
            }

            return Math.max(dp[n - 1][0], dp[n - 1][1]);
        }

    }

    /**
     * 方法二：优化的动态规划
     */

    /**
     * 方法三：贪心
     * 我们只需要统计该序列中「峰」与「谷」的数量即可（注意序列两端的数也是「峰」或「谷」），但需要注意处理相邻的相同元素。
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.8 MB,击败了73.89% 的Java用户
     */
    private class S3 {

        public int wiggleMaxLength(int[] nums) {
            if (nums.length == 1) return 1;
            int res = 1, curDif = 0, preDif = 0;

            for (int i = 0; i < nums.length - 1; i++) {
                curDif = nums[i + 1] - nums[i];

                if ((curDif > 0 && preDif <= 0) || (curDif < 0 && preDif >= 0)) {
                    res++;
                    preDif = curDif;
                }
            }

            return res;
        }

    }

}
