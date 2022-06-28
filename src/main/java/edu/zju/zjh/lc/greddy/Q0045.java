package edu.zju.zjh.lc.greddy;

/**
 * @author: zjh
 * @date : 2022/6/27 10:05
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0045 {

    /**
     * 2020年，第一次刷
     */
    private class S1 {

        public int jump(int[] nums) {
            int res = 0;
            int[] used = new int[nums.length];

            int nowIn = 0, maxDis = 0, update = 0;
            while (maxDis < nums.length - 1) {
                for (int i = nowIn; i <= maxDis; i++) {
                    if (i >= nums.length) {
                        return res;
                    }
                    update = Math.max(update, i + nums[i]);
                }
                nowIn = maxDis + 1;
                maxDis = update;

                res++;
            }

            return res;
        }

    }

    /**
     * 贪心算法 O(n)
     * 执行耗时:1 ms,击败了99.04% 的Java用户
     * 内存消耗:42.2 MB,击败了8.26% 的Java用户
     */
    private class S2 {

        public int jump(int[] nums) {
            int l = 0, r = 0, step = 0;

            while (l <= r && r < nums.length - 1) {
                step++;
                int t = r;
                while (l <= t && r < nums.length - 1) {
                    r = Math.max(r, l + nums[l]);
                    l++;
                }
            }

            return step;
        }

    }

}
