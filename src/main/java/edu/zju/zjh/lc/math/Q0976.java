package edu.zju.zjh.lc.math;

import java.util.Arrays;

/**
 * @author: zjh
 * @date : 2022/7/22 22:07
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0976 {

    /**
     * 方法零：暴力
     * 执行耗时:2468 ms,击败了5.86% 的Java用户
     * 内存消耗:42.1 MB,击败了13.12% 的Java用户
     */
    private class S1 {

        public int largestPerimeter(int[] nums) {
            int n = nums.length;

            Arrays.sort(nums);
            for (int i = n - 1; i >= 2; i--) {
                for (int j = i - 1; j >= 1; j--) {
                    for (int k = j - 1; k >= 0; k--) {
                        if (nums[j] + nums[k] > nums[i]) {
                            return nums[j] + nums[k] + nums[i];
                        }
                    }
                }
            }

            return 0;
        }

    }

    /**
     * 方法一：贪心 + 排序
     * 执行耗时:8 ms,击败了99.62% 的Java用户
     * 内存消耗:42 MB,击败了14.74% 的Java用户
     */
    private class S2 {

        public int largestPerimeter(int[] nums) {
            int n = nums.length;

            Arrays.sort(nums);
            for (int i = n - 1; i >= 2; i--) {
                if (nums[i - 1] + nums[i - 2] > nums[i]) {
                    return nums[i] + nums[i - 1] + nums[i - 2];
                }
            }

            return 0;
        }

    }

}
