package edu.zju.zjh.lc.bs;

/**
 * @author: zjh
 * @date : 2022/3/3 14:35
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0153 {

    public int findMin(int[] nums) {
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

}
