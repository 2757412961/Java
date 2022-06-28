package edu.zju.zjh.lc.doublepointer.leftright;

import java.util.Arrays;

/**
 * @author: zjh
 * @date : 2022/6/27 19:26
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0556 {

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.4 MB,击败了18.59% 的Java用户
     */
    private class S1 {
        public void swap(int[] nums, int x, int y) {
            int temp = nums[x];
            nums[x] = nums[y];
            nums[y] = temp;
        }

        public void reverse(int[] nums, int l, int r) {
            while (l < r) {
                swap(nums, l++, r--);
            }
        }

        public int nextGreaterElement(int n) {
            int[] nums = new int[11];
            int l = 0, r = 0, len = 0;
            long res = 0;

            // 转换成数组
            while (n > 0) {
                nums[len++] = n % 10;
                n /= 10;
            }
            if (len <= 1) return -1;
            reverse(nums, 0, len - 1);

            // 找到翻转位置，小值
            l = len - 2;
            while (0 <= l && nums[l] >= nums[l + 1]) {
                l--;
            }
            if (l == -1) return -1;

            // 找到大值
            r = len - 1;
            while (r > l && nums[r] <= nums[l]) {
                r--;
            }
            swap(nums, l, r);

            // 翻转位置
            reverse(nums, l + 1, len - 1);

            // 转换成数字
            for (int i = 0; i < len; i++) {
                res = res * 10 + nums[i];
            }

            if (res > Integer.MAX_VALUE) return -1;

            return (int) res;
        }

    }

}
