package edu.zju.zjh.lc.dp.rob;

/**
 * @author: zjh
 * @date : 2022/6/27 21:41
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0740 {

    /**
     * 方法一：动态规划
     * 若选择了 x，则可以获取 sum[x] 的点数，且无法再选择 x−1 和 x+1。这与「198. 打家劫舍」是一样的
     * 执行耗时:3 ms,击败了53.31% 的Java用户
     * 内存消耗:41.8 MB,击败了16.02% 的Java用户
     */
    private class S1 {

        public int deleteAndEarn(int[] nums) {
            int[] cnt = new int[10001];
            int n = 0;

            for (int i = 0; i < nums.length; i++) {
                cnt[nums[i]] += nums[i];
                n = Math.max(n, nums[i]);
            }

            int[] dp = new int[n + 1];
            dp[1] = cnt[1];
            for (int i = 2; i <= n; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + cnt[i]);
            }

            return dp[n];
        }

    }

}
