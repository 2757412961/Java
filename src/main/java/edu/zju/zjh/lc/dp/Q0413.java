package edu.zju.zjh.lc.dp;

/**
 * @author: zjh
 * @date : 2022/6/27 17:35
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0413 {

    /**
     * 滑动窗口
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.6 MB,击败了6.53% 的Java用户
     */
    private class S1 {

        public int numberOfArithmeticSlices(int[] nums) {
            if (nums.length < 3) return 0;
            int n = nums.length;
            int res = 0, l = 0, r = 2;

            while (r < n) {
                while (r > l + 1 && nums[l + 1] - nums[l] != nums[r] - nums[r - 1]) {
                    l++;
                }

                res += r - l - 1;
                r++;
            }

            return res;
        }

    }

}
