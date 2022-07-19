package edu.zju.zjh.lc.backtrack.combine;

import java.util.LinkedList;

/**
 * @author: zjh
 * @date : 2022/7/19 9:57
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0377 {

    /**
     * 方法一：回溯
     * Time Limit Exceeded
     */
    private class S1 {

        private int res = 0;
        private LinkedList<Integer> path = new LinkedList<>();

        private void backTrack(int[] nums, int target, int sum) {
            if (sum > target) return;
            if (sum == target) {
                res++;
            }

            for (int i = 0; i < nums.length; i++) {
                backTrack(nums, target, sum + nums[i]);
            }
        }

        public int combinationSum4(int[] nums, int target) {
            backTrack(nums, target, 0);
            return res;
        }

    }

    /**
     * 方法二：动态规划
     * 执行耗时:1 ms,击败了97.60% 的Java用户
     * 内存消耗:38.9 MB,击败了38.62% 的Java用户
     */
    private class S2 {

        public int combinationSum4(int[] nums, int target) {
            int[] dp = new int[target + 1];

            dp[0] = 1;
            for (int i = 1; i <= target; i++) {
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] <= i) {
                        dp[i] += dp[i - nums[j]];
                    }
                }
            }

            return dp[target];
        }

    }

    /**
     * !!!
     * 爬楼梯问题 楼梯的阶数一共为target，一次可以走的步数为nums[i]。 一共有多少种走法？问题搞定。
     */

}
