package edu.zju.zjh.lc.binarysearch;

/**
 * @author: zjh
 * @date : 2022/5/16 13:48
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0035 {

    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length, m = -1;

        while (l < r) {
            m = (r - l) / 2 + l;
            if (nums[m] > target) {
                r = m;
            } else if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] == target) {
                return m;
            }
        }

        return l;
    }

}
