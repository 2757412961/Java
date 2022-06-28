package edu.zju.zjh.lc.dp.subsequence;

/**
 * @author: zjh
 * @date : 2022/6/27 20:31
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0673 {

    /**
     * 方法一：动态规划
     * 执行耗时:18 ms,击败了72.65% 的Java用户
     * 内存消耗:41.4 MB,击败了6.16% 的Java用户
     */
    private class S1 {

        public int findNumberOfLIS(int[] nums) {
            int n = nums.length, max = 0, res = 0;
            int[] dp = new int[n];
            int[] cnt = new int[n];

            for (int i = 0; i < n; i++) {
                dp[i] = 1;
                cnt[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        if (dp[i] < dp[j] + 1) {
                            dp[i] = dp[j] + 1;
                            cnt[i] = cnt[j];
                        } else if (dp[i] == dp[j] + 1) {
                            cnt[i] += cnt[j];
                        }
                    }
                }
                max = Math.max(max, dp[i]);
            }

            for (int i = 0; i < n; i++) {
                if (dp[i] == max) {
                    res += cnt[i];
                }
            }

            return res;
        }

    }

    /**
     * 方法二：贪心 + 前缀和 + 二分查找
     */


}
