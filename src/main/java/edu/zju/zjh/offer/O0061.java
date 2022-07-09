package edu.zju.zjh.offer;

import java.util.Arrays;

/**
 * @author: zjh
 * @date : 2022/4/23 下午 08:26
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0061 {

    /**
     * 方法二：排序 + 遍历
     * 执行耗时:1 ms,击败了26.92% 的Java用户
     * 内存消耗:38.9 MB,击败了64.35% 的Java用户
     */
    private class S1 {

        public boolean isStraight(int[] nums) {
            Arrays.sort(nums);
            int count = 0, sum = 0;

            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == 0) {
                    count++;
                } else {
                    int a = nums[i + 1] - nums[i] - 1;
                    if (a < 0) return false;
                    sum += a;
                }
            }

            return count >= sum;
        }

    }

    /**
     * 方法一： 集合 Set + 遍历
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.5 MB,击败了5.13% 的Java用户
     */
    private class S2 {

        public boolean isStraight(int[] nums) {
            int[] map = new int[14];
            int min = 13, max = 1;

            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (num == 0) continue;
                if (map[num] == 1) return false;
                map[num]++;

                min = Math.min(min, num);
                max = Math.max(max, num);
            }

            return max - min <= 5;
        }

    }

}
