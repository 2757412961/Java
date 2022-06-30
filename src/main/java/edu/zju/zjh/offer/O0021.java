package edu.zju.zjh.offer;

/**
 * @author: zjh
 * @date : 2022/3/12 16:48
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0021 {

    /**
     * 左右指针
     */
    private class S1 {

        private void swap(int[] nums, int x, int y) {
            int temp = nums[x];
            nums[x] = nums[y];
            nums[y] = temp;
        }

        public int[] exchange(int[] nums) {
            int left = 0, right = nums.length - 1;

            while (left <= right) {
                if ((nums[left] & 1) == 0) {
                    swap(nums, left, right);
                    right--;
                    continue;
                }
                left++;
            }

            return nums;
        }

    }

    /**
     * 二刷
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:49.4 MB,击败了24.44% 的Java用户
     */
    private class S2 {

        private void swap(int[] nums, int x, int y) {
            int temp = nums[x];
            nums[x] = nums[y];
            nums[y] = temp;
        }

        public int[] exchange(int[] nums) {
            int end = nums.length - 1;

            for (int i = 0; i <= end; i++) {
                if ((nums[i] & 1) == 0) {
                    swap(nums, i, end--);
                    i--;
                }
            }

            return nums;
        }

    }

}
