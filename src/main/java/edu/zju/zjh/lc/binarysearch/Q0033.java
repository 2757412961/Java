package edu.zju.zjh.lc.binarysearch;

/**
 * @author: zjh
 * @date : 2022/5/23 10:26
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0033 {

    private class S1 {

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

    /**
     * 二刷
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.3 MB,击败了5.16% 的Java用户
     */
    private class S2 {

        public int search(int[] nums, int target) {
            int l = 0, r = nums.length - 1, m = -1;

            while (l <= r) {
                m = l + (r - l) / 2;
                if (nums[l] < nums[r]) {
                    // 判断是顺序数组
                    if (nums[m] == target) {
                        return m;
                    } else if (nums[m] < target) {
                        l = m + 1;
                    } else if (nums[m] > target) {
                        r = m - 1;
                    }
                } else {
                    // 判断是旋转数组
                    if (nums[m] == target) {
                        return m;
                    }
                    if (nums[l] <= target && nums[l] <= nums[m]) {
                        // 判断m和target都在左侧
                        if (nums[m] < target) {
                            l = m + 1;
                        } else if (nums[m] > target) {
                            r = m - 1;
                        }
                    } else if (nums[l] <= target && nums[l] > nums[m]) {
                        // 判断m和target都在左右侧
                        r = m - 1;
                    } else if (nums[l] > target && nums[l] <= nums[m]) {
                        // 判断m和target都在左右侧
                        l = m + 1;
                    } else if (nums[l] > target && nums[l] > nums[m]) {
                        // 判断m和target都在右侧
                        if (nums[m] < target) {
                            l = m + 1;
                        } else if (nums[m] > target) {
                            r = m - 1;
                        }
                    }
                }
            }

            return -1;
        }

    }

}
