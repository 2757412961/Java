package edu.zju.zjh.topk.ali;

import java.util.Random;

/**
 * @author: zjh
 * @date : 2022/5/10 21:22
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0912_qs {

    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public int partition(int[] nums, int x, int y) {
        if (x >= y) return x;

        int p = x + new Random().nextInt(y - x + 1);
        swap(nums, x, p);

        int j = y;
        for (int i = x + 1; i <= j; i++) {
            if (nums[x] < nums[i]) {
                swap(nums, i--, j--);
            }
        }
        swap(nums, x, j);

        partition(nums, x, j - 1);
        partition(nums, j + 1, y);

        return j;
    }

    public int[] sortArray(int[] nums) {
        partition(nums, 0, nums.length - 1);

        return nums;
    }

}
