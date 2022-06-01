package edu.zju.zjh.lc.array;

/**
 * @author: zjh
 * @date : 2022/6/1 19:30
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q2104 {

    /**
     * 暴力枚举
     * 执行耗时:17 ms,击败了77.11% 的Java用户
     * 内存消耗:41.2 MB,击败了29.20% 的Java用户
     */
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long res = 0;

        for (int i = 0; i < n; i++) {
            int min = nums[i], max = nums[i];
            for (int j = i + 1; j < n; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                res += max - min;
            }
        }

        return res;
    }

}
