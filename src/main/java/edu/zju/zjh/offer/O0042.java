package edu.zju.zjh.offer;

/**
 * @author: zjh
 * @date : 2022/4/14 上午 10:17
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0042 {

    /**
     * 方法一：动态规划
     */
    private class S1 {

        public int maxSubArray(int[] nums) {
            int n = nums.length, res = nums[0];
            int[] dp = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                dp[i] = Math.max(dp[i - 1] + nums[i - 1], nums[i - 1]);
                res = Math.max(dp[i], res);
            }

            return res;
        }

    }

    /**
     * 方法二：贪心
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:48.2 MB,击败了14.83% 的Java用户
     */
    private class S2 {

        public int maxSubArray(int[] nums) {
            int res = Integer.MIN_VALUE, sum = 0;

            for (int i = 0; i < nums.length; i++) {
                if (sum < 0) sum = 0;
                sum += nums[i];

                res = Math.max(res, sum);
            }

            return res;
        }

    }

}
