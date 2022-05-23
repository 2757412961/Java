package edu.zju.zjh.lc.binarysearch;

/**
 * @author: zjh
 * @date : 2022/5/23 10:26
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0033 {

    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1, m = 0;

        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[l] <= nums[m]) {
                if (target == nums[m]) {
                    return m;
                } else if (target > nums[m]) {
                    l = m + 1;
                } else if (target < nums[m]) {
                    if (nums[l] <= target) {
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
            } else if (nums[m] <= nums[r]) {
                if (target == nums[m]) {
                    return m;
                } else if (target > nums[m]) {
                    if (target <= nums[r]) {
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                } else if (target < nums[m]) {
                    r = m - 1;
                }
            }
        }

        return -1;
    }

}
