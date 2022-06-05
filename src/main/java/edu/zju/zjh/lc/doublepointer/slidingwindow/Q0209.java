package edu.zju.zjh.lc.doublepointer.slidingwindow;

/**
 * @author: zjh
 * @date : 2022/6/5 14:05
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0209 {


    /**
     * 执行耗时:1 ms,击败了99.98% 的Java用户
     * 内存消耗:41.6 MB,击败了10.94% 的Java用户
     */
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE, sum = 0, l = 0, r = 0, n = nums.length;

        while (r < n) {
            sum += nums[r++];

            while (l < r && sum >= target) {
                res = Math.min(res, r - l);
                sum -= nums[l++];
            }
        }

        return res > nums.length ? 0 : res;
    }

}
