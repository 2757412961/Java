package edu.zju.zjh.offer;

/**
 * @author: zjh
 * @date : 2022/4/15 下午 03:25
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0053_II {

    /**
     * 方法一：遍历
     */
    private class S1 {

        public int missingNumber(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i) return i;
            }

            return nums.length;
        }

    }

    /**
     * 方法二：二分法
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:42 MB,击败了57.58% 的Java用户
     */
    private class S2 {

        public int missingNumber(int[] nums) {
            int l = 0, r = nums.length, m = -1;

            while (l < r) {
                m = (l + r) / 2;
                if (m == nums[m]) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }

            return l;
        }

    }

}
