package edu.zju.zjh.lc.array;

/**
 * @author: zjh
 * @date : 2022/6/23 下午 04:34
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0918 {

    /**
     * 我裂开，官方题解看不懂。找了下面这种方法
     * https://leetcode.cn/problems/maximum-sum-circular-subarray/solution/wo-hua-yi-bian-jiu-kan-dong-de-ti-jie-ni-892u/
     * 第一种情况：这个子数组不是环状的，就是说首尾不相连。
     * 第二种情况：这个子数组一部分在首部，一部分在尾部，我们可以将这第二种情况转换成第一种情况
     * = 数组总和 + max(-subarray) = 数组总和 - min(subarry)
     * <p>
     * 执行耗时:3 ms,击败了96.78% 的Java用户
     * 内存消耗:46.3 MB,击败了69.00% 的Java用户
     */
    private class S1 {

        public int maxSubarraySumCircular(int[] nums) {
            int max = Integer.MIN_VALUE, maxMin = Integer.MIN_VALUE;
            int sum = 0, sumMin = 0, total = 0;

            for (int i = 0; i < nums.length; i++) {
                // 第一种情况：这个子数组不是环状的，就是说首尾不相连。
                if (sum < 0) sum = 0;
                sum += nums[i];
                max = Math.max(max, sum);

                // 第二种情况：这个子数组一部分在首部，一部分在尾部，我们可以将这第二种情况转换成第一种情况
                if (sumMin < 0) sumMin = 0;
                sumMin += -nums[i];
                maxMin = Math.max(maxMin, sumMin);

                total += nums[i];
            }

            // 一种特殊情况是数组全为负数，也就是SUM-最小子序和==0，最大子序和等于数组中最大的那个
            if (total - maxMin == 0) return max;

            return Math.max(max, total - maxMin);
        }

    }

}
