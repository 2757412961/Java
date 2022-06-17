package edu.zju.zjh.lc.doublepointer.slidingwindow;

/**
 * @author: zjh
 * @date : 2022/6/16 21:40
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0173 {

    /**
     * 执行耗时:5 ms,击败了38.53% 的Java用户
     * 内存消耗:47.9 MB,击败了53.69% 的Java用户
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int l = 0, r = 0, n = nums.length;
        long product = 1;

        while (r < n) {
            product *= nums[r++];

            while (l < r && product >= k) {
                product /= nums[l++];
            }

            res += r - l;
        }

        return res;
    }

}
