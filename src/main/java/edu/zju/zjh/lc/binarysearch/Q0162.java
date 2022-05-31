package edu.zju.zjh.lc.binarysearch;

/**
 * @author: zjh
 * @date : 2022/5/31 17:02
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0162 {

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.5 MB,击败了89.83% 的Java用户
     */
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums.length == 2) return nums[0] > nums[1] ? 0 : 1;

        int l = 0, r = nums.length - 1, m = -1;

        while (l <= r) {
            m = l + (r - l) / 2;
            if (m == 0) {
                // 边界情况的处理
                if (nums[m] > nums[m + 1]) {
                    return m;
                } else {
                    l++;
                }
            } else if (m == nums.length - 1) {
                // 边界情况的处理
                if (nums[m - 1] < nums[m]) {
                    return m;
                } else {
                    r--;
                }
            } else if (nums[m - 1] < nums[m] && nums[m] > nums[m + 1]) {
                // 高峰
                return m;
            } else if (nums[m - 1] < nums[m] && nums[m] < nums[m + 1]) {
                // 往高处走
                l = m + 1;
            } else if (nums[m - 1] > nums[m] && nums[m] > nums[m + 1]) {
                // 往高处走
                r = m - 1;
            } else if (nums[m - 1] > nums[m] && nums[m] < nums[m + 1]) {
                // 低谷
                l++;
            }
        }

        return -1;
    }

}
