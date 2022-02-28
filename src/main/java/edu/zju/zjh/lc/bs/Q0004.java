package edu.zju.zjh.lc.bs;

/**
 * @author: zjh
 * @date : 2022/2/28 14:50
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0004 {

    public double getKthNum(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int i = 0, j = 0;

        while (k != 0) {
            if (i >= m) {
                return nums2[j + k - 1];
            }
            if (j >= n) {
                return nums1[i + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[i], nums2[j]);
            }

            int offset = k / 2;
            int afteri = Math.min(i + offset, m) - 1;
            int afterj = Math.min(j + offset, n) - 1;
            if (nums1[afteri] <= nums2[afterj]) {
                k -= afteri - i + 1;
                i = afteri + 1;
            } else {
                k -= afterj - j + 1;
                j = afterj + 1;
            }
        }

        return 0;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int all = m + n;
        int half = all / 2;

        if (all % 2 == 0) {
            return getKthNum(nums1, nums2, half) / 2 + getKthNum(nums1, nums2, half + 1) / 2;
        } else {
            return getKthNum(nums1, nums2, half + 1);
        }
    }

    public static void main(String[] args) {
//        System.out.println(new Q0004().findMedianSortedArrays(new int[]{1, 3, 4, 8}, new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(new Q0004().findMedianSortedArrays(new int[]{0, 0, 0, 0, 0}, new int[]{-1, 0, 0, 0, 0, 0, 1}));

    }
}
