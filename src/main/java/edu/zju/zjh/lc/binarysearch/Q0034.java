package edu.zju.zjh.lc.binarysearch;

/**
 * @author: zjh
 * @date : 2022/5/27 9:17
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0034 {

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:44.4 MB,击败了70.60% 的Java用户
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int low = -1, high = -1;
        int l, r, m, n = nums.length;

        // left side
        l = 0;
        r = n;
        while (l < r) {
            m = l + (r - l) / 2;
            if (nums[m] == target) {
                r = m;
            } else if (nums[m] > target) {
                r = m;
            } else if (nums[m] < target) {
                l = m + 1;
            }
        }
        low = l;

        // right side
        l = 0;
        r = n;
        while (l < r) {
            m = l + (r - l) / 2;
            if (nums[m] == target) {
                l = m + 1;
            } else if (nums[m] > target) {
                r = m;
            } else if (nums[m] < target) {
                l = m + 1;
            }
        }
        high = r;

        if (low == n || nums[low] != target) return new int[]{-1, -1};

        return new int[]{low, high - 1};
    }

}
