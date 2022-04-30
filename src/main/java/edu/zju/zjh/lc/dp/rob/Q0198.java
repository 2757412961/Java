package edu.zju.zjh.lc.dp.rob;

/**
 * @author: zjh
 * @date : 2022/4/30 10:01
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0198 {

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[1] = nums[0];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Q0198().rob(new int[]{1, 2, 3, 1}));
    }

}
