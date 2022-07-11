package edu.zju.zjh.lc.greddy;

/**
 * @author: zjh
 * @date : 2022/7/11 16:18
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q1855 {

    /**
     * 方法一：双指针
     * 执行耗时:3 ms,击败了78.99% 的Java用户
     * 内存消耗:53.6 MB,击败了94.82% 的Java用户
     */
    private class S1 {

        public int maxDistance(int[] nums1, int[] nums2) {
            int res = 0;
            int m = nums1.length, n = nums2.length;
            int i = m - 1, j = n - 1;

            // 确保初始化时，j大于i
            while (j >= 0 && nums1[i] > nums2[j]) {
                j--;
            }

            while (j >= 0) {
                while (i >= 0 && nums1[i] <= nums2[j]) {
                    i--;
                }
                res = Math.max(res, j - i - 1);

                j--;
            }

            return res;
        }

    }

}
