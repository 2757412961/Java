package edu.zju.zjh.lc.binarysearch;

/**
 * @author: zjh
 * @date : 2022/5/23 16:25
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0081 {

    /**
     * 方法一：二分查找
     */
    private class S1 {

        public boolean search(int[] nums, int target) {
            int l = 0, r = nums.length - 1, m;

            while (l <= r) {
                m = l + (r - l) / 2;
                if (nums[m] == target) {
                    return true;
                }

                if (nums[l] == nums[m]) {
                    l++;
                } else if (nums[r] == nums[m]) {
                    r--;
                } else if (nums[l] < nums[m]) {
                    if (target < nums[m]) {
                        if (nums[l] <= target) {
                            r = m - 1;
                        } else {
                            l = m + 1;
                        }
                    } else if (nums[m] < target) {
                        l = m + 1;
                    }
                } else if (nums[m] < nums[r]) {
                    if (target < nums[m]) {
                        r = m - 1;
                    } else if (nums[m] < target) {
                        if (target <= nums[r]) {
                            l = m + 1;
                        } else {
                            r = m - 1;
                        }
                    }
                }
            }

            return false;
        }

    }

    /**
     * 二刷
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41 MB,击败了66.52% 的Java用户
     */
    private class S2 {

        public boolean search(int[] nums, int target) {
            int l = 0, r = nums.length - 1, m = -1;

            while (l <= r) {
                m = l + (r - l) / 2;
                if (nums[l] < nums[r]) {
                    if (nums[m] == target) {
                        return true;
                    } else if (nums[m] > target) {
                        r = m - 1;
                    } else if (nums[m] < target) {
                        l = m + 1;
                    }
                } else {
                    if (nums[m] == target) {
                        return true;
                    }
                    if (nums[l] == nums[m]) {
                        l++;
                    } else if (nums[l] > nums[m]) {
                        if (target > nums[m]) {
                            if (target <= nums[r]) {
                                l = m + 1;
                            } else {
                                r = m - 1;
                            }
                        } else if (target < nums[m]) {
                            r = m - 1;
                        }
                    } else if (nums[l] < nums[m]) {
                        if (target > nums[m]) {
                            l = m + 1;
                        } else if (target < nums[m]) {
                            if (target >= nums[l]) {
                                r = m - 1;
                            } else {
                                l = m + 1;
                            }
                        }
                    }
                }
            }

            return false;
        }

    }

    public static void main(String[] args) {
        System.out.println(new Q0081().new S1().search(new int[]{5, 1, 3}, 3));
        System.out.println(new Q0081().new S1().search(new int[]{1, 3}, 3));
    }

}
