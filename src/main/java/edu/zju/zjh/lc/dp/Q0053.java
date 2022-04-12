package edu.zju.zjh.lc.dp;

/**
 * @author: zjh
 * @date : 2022/4/12 上午 11:44
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0053 {

    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int[] dp = new int[nums.length + 1];

        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(nums[i - 1], nums[i - 1] + dp[i - 1]);
        }

        for (int i = 1; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }

}
