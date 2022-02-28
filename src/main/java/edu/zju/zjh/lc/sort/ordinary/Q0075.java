package edu.zju.zjh.lc.sort.ordinary;

/**
 * @author: zjh
 * @date : 2022/2/24 13:57
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0075 {

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0, righ = n - 1;
        int i = 0;

        while (i <= righ) {
            if (nums[i] == 0) {
                swap(nums, i, left);
                left++;
                if (i <= left) i = left;
            } else if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, righ);
                righ--;
            }
        }
    }

}
