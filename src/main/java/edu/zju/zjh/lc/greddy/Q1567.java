package edu.zju.zjh.lc.greddy;

/**
 * @author: zjh
 * @date : 2022/7/11 15:24
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q1567 {

    /**
     * 方法一：动态规划
     */

    /**
     * 方法二：贪心算法
     * 执行耗时:5 ms,击败了14.43% 的Java用户
     * 内存消耗:57.2 MB,击败了45.15% 的Java用户
     */
    private class S1 {

        public int getMaxLen(int[] nums) {
            int res = 0, cnt = 0;
            boolean positive = true;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    cnt = 0;
                    positive = true;
                    continue;
                }

                cnt++;
                if (nums[i] < 0) positive = !positive;
                if (positive) res = Math.max(res, cnt);
            }

            cnt = 0;
            positive = true;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] == 0) {
                    cnt = 0;
                    positive = true;
                    continue;
                }

                cnt++;
                if (nums[i] < 0) positive = !positive;
                if (positive) res = Math.max(res, cnt);
            }

            return res;
        }

    }

}
