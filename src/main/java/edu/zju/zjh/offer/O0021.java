package edu.zju.zjh.offer;

/**
 * @author: zjh
 * @date : 2022/3/12 16:48
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0021 {

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
