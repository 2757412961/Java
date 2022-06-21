package edu.zju.zjh.lc.doublepointer;

/**
 * @author: zjh
 * @date : 2022/5/26 13:54
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0031 {

    /**
     * 方法一：两遍扫描 时间复杂度：O(N)
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:42 MB,击败了5.97% 的Java用户
     */
    private class S1 {

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public void nextPermutation(int[] nums) {
            int n = nums.length;
            int l = 0, r = 0;

            for (l = n - 2, r = n - 1; l >= 0; l--, r--) {
                if (nums[l] < nums[r]) {
                    break;
                }
            }

            if (l >= 0) {
                for (r = n - 1; r > l; r--) {
                    if (nums[r] > nums[l]) {
                        break;
                    }
                }
                swap(nums, l, r);
            }

            l++;
            r = n - 1;
            while (l < r) {
                swap(nums, l++, r--);
            }
        }

    }

    /**
     * 二刷
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.9 MB,击败了14.27% 的Java用户
     */
    private class S2 {

        public void swap(int[] nums, int x, int y) {
            int temp = nums[x];
            nums[x] = nums[y];
            nums[y] = temp;
        }

        public void nextPermutation(int[] nums) {
            int n = nums.length;
            int l = n - 2, r = n - 1;

            // 找到第一个不是递减的数
            while (l >= 0) {
                if (nums[l] < nums[l + 1]) break;
                l--;
            }

            // 如果存在，交换
            if (l >= 0) {
                while (r > l) {
                    if (nums[l] < nums[r]) break;
                    r--;
                }
                swap(nums, l, r);
            }

            // 倒序
            l++;
            r = n - 1;
            while (l < r) {
                swap(nums, l++, r--);
            }
        }

    }

}
