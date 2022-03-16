package edu.zju.zjh.lc.doublepointer.leftright;

import java.util.Arrays;

/**
 * @author: zjh
 * @date : 2022/3/16 14:44
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0088 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur1 = m - 1, cur2 = n - 1, idx = m + n - 1;

        while (cur1 >= 0 && cur2 >= 0) {
            if (nums1[cur1] > nums2[cur2]) {
                nums1[idx--] = nums1[cur1--];
            } else {
                nums1[idx--] = nums2[cur2--];
            }
        }
        while (cur1 >= 0) {
            nums1[idx--] = nums1[cur1--];
        }
        while (cur2 >= 0) {
            nums1[idx--] = nums2[cur2--];
        }
    }

}
