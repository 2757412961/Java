package edu.zju.zjh.lcold;

import java.util.Deque;
import java.util.LinkedList;

public class T1438 {

    public int longestSubarray(int[] nums, int limit) {
        int res = 0;
        int left = 0, righ = 0;

        Deque<Integer> maxDeq = new LinkedList<>();
        Deque<Integer> minDeq = new LinkedList<>();

        while (righ < nums.length) {
            while (!maxDeq.isEmpty() && maxDeq.peekLast() < nums[righ]) {
                maxDeq.pollLast();
            }
            maxDeq.add(nums[righ]);
            while (!minDeq.isEmpty() && minDeq.peekLast() > nums[righ]) {
                minDeq.pollLast();
            }
            minDeq.add(nums[righ]);

            while (!maxDeq.isEmpty() && !minDeq.isEmpty() && maxDeq.peekFirst() - minDeq.peekFirst() > limit) {
                if (!maxDeq.isEmpty() && nums[left] == maxDeq.peekFirst()) {
                    maxDeq.pollFirst();
                }
                if (!minDeq.isEmpty() && nums[left] == minDeq.peekFirst()) {
                    minDeq.pollFirst();
                }
                left++;
            }

            res = Math.max(res, righ - left + 1);
            righ++;
        }

        return res;
    }

    public int longestSubarray_violence(int[] nums, int limit) {
        if (nums.length <= 0) {
            return 0;
        }

        int res = 0;
        int left = 0, righ = 0;
        int min = nums[0], max = nums[0];

        while (righ < nums.length) {
            min = Math.min(min, nums[righ]);
            max = Math.max(max, nums[righ]);

            if (max - min > limit) {
                left++;
                min = max = nums[righ];
                for (int i = left; i < righ; i++) {
                    min = Math.min(min, nums[i]);
                    max = Math.max(max, nums[i]);
                }
                continue;
            }

            res = Math.max(res, righ - left + 1);
            righ++;
        }

        return res;
    }

    public static void main(String[] args) {
//        给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
//        如果不存在满足条件的子数组，则返回 0 。

//        示例 1：
//        输入：nums = [8,2,4,7], limit = 4
//        输出：2
//        解释：所有子数组如下：
//                [8] 最大绝对差 |8-8| = 0 <= 4.
//                [8,2] 最大绝对差 |8-2| = 6 > 4.
//                [8,2,4] 最大绝对差 |8-2| = 6 > 4.
//                [8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
//                [2] 最大绝对差 |2-2| = 0 <= 4.
//                [2,4] 最大绝对差 |2-4| = 2 <= 4.
//                [2,4,7] 最大绝对差 |2-7| = 5 > 4.
//                [4] 最大绝对差 |4-4| = 0 <= 4.
//                [4,7] 最大绝对差 |4-7| = 3 <= 4.
//                [7] 最大绝对差 |7-7| = 0 <= 4.
//        因此，满足题意的最长子数组的长度为 2 。

//        示例 2：
//        输入：nums = [10,1,2,4,7,2], limit = 5
//        输出：4
//        解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。

//        示例 3：
//        输入：nums = [4,2,2,2,4,4,2,2], limit = 0
//        输出：3

//        int[] nums = new int[]{8, 2, 4, 7};
//        int limit = 4;

//        int[] nums = new int[]{4, 2, 2, 2, 4, 4, 2, 2};
//        int limit = 0;

        int[] nums = new int[]{7, 3, 4, 9, 2, 4, 7};
        int limit = 4;

        System.out.println(new T1438().longestSubarray(nums, limit));
        System.out.println(new T1438().longestSubarray_violence(nums, limit));
    }
}
