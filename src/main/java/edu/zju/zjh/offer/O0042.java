package edu.zju.zjh.offer;

/**
 * @author: zjh
 * @date : 2022/4/14 上午 10:17
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0042 {

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
