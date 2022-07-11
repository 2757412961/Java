package edu.zju.zjh.lc.binarysearch;

import java.util.Arrays;

/**
 * @author: zjh
 * @date : 2022/7/11 15:50
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q1608 {

    /**
     * 方法一：暴力法
     * 执行耗时:2 ms,击败了15.12% 的Java用户
     * 内存消耗:39.5 MB,击败了12.84% 的Java用户
     */
    private class S1 {

        public int specialArray(int[] nums) {
            int n = nums.length, idx = 0;

            Arrays.sort(nums);
            for (int i = 0; i <= n; i++) {
                while (idx < n && nums[idx] < i) {
                    idx++;
                }

                if (i == n - idx) return i;
            }

            return -1;
        }

    }

    /**
     * 方法二：二分查找
     * 作者：vanilla111
     * 链接：https://leetcode.cn/problems/special-array-with-x-elements-greater-than-or-equal-x/solution/java-by-vanilla111-rgzj/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * <p>
     * 执行耗时:1 ms,击败了81.55% 的Java用户
     * 内存消耗:39.2 MB,击败了49.21% 的Java用户
     */
    private class S2 {

        class Solution {
            public int specialArray(int[] nums) {
                Arrays.sort(nums);
                int n = nums.length;
                int l = 0, r = n;
                while (l <= r) {
                    int x = (l + r) >> 1;
                    int idx = binarySearch(nums, x); // nums中第一个大于等于x的元素位置
                    if (x == n - idx) {
                        return x;
                    } else if (x < n - idx) { // 大于等于x的元素太多了，所以下一轮搜索要增大x的取值范围
                        l = x + 1;
                    } else { // 反之，减少x的取值范围
                        r = x - 1;
                    }
                }
                return -1;
            }

            private int binarySearch(int[] nums, int x) {
                int l = 0, r = nums.length - 1;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    int val = nums[mid];
                    if (val >= x) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
                return l;
            }
        }

    }

}
