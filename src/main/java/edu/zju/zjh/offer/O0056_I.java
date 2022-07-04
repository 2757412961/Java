package edu.zju.zjh.offer;

/**
 * @author: zjh
 * @date : 2022/3/9 10:41
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0056_I {

    private class S1 {

        public int[] singleNumbers(int[] nums) {
            int x = 0, y = 0, xy = 0, split = 1;

            for (int i = 0; i < nums.length; i++) {
                xy ^= nums[i];
            }

            while ((xy & split) == 0) {
                split <<= 1;
            }

            for (int i = 0; i < nums.length; i++) {
                if ((nums[i] & split) == 0) {
                    x ^= nums[i];
                } else {
                    y ^= nums[i];
                }
            }

            return new int[]{x, y};
        }

    }

    /**
     * 二刷
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:43.1 MB,击败了23.12% 的Java用户
     */
    private class S2 {

        public int[] singleNumbers(int[] nums) {
            int x = 0, y = 0, xy = 0, split = 1;

            for (int i = 0; i < nums.length; i++) {
                xy ^= nums[i];
            }

            while ((xy & split) == 0) {
                split <<= 1;
            }

            for (int i = 0; i < nums.length; i++) {
                if ((nums[i] & split) == 0) {
                    x ^= nums[i];
                } else {
                    y ^= nums[i];
                }
            }

            return new int[]{x, y};
        }

    }

}
