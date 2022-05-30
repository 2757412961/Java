package edu.zju.zjh.lc.binarysearch;

/**
 * @author: zjh
 * @date : 2022/3/3 14:35
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0153 {

    public int findMin1(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1, mid = 0;

        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (nums[left] < nums[right]) {
                return nums[left];
            } else {
                if (nums[left] < nums[mid]) {
                    left = mid + 1;
                } else if (nums[left] > nums[mid]) {
                    right = mid;
                } else if (nums[left] == nums[mid]) {
                    left++;
                }
            }
        }

        return nums[mid];
    }

    /**
     * 二刷
     * 二分查找
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41 MB,击败了48.44% 的Java用户
     */
    public int findMin(int[] nums) {
        int l = 0, r = nums.length, m = -1;

        while (l < r) {
            if (nums[l] < nums[r]) {
                return nums[l];
            } else {
                if (nums[m] > nums[l]) {
                    l = m + 1;
                } else if (nums[m] < nums[l]) {
                    r = m;
                } else if (nums[m] == nums[l]) {
                    l++;
                }
            }
        }

        return nums[l];
    }

}
