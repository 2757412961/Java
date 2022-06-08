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

    /**
     * 二刷
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40 MB,击败了24.75% 的Java用户
     */
    public void sortColors2(int[] nums) {
        int l = 0, r = nums.length - 1, pos = 0;

        while (pos <= r) {
            if (nums[pos] == 0) {
                swap(nums, pos, l++);
                if (pos < l) pos = l;
            } else if (nums[pos] == 1) {
                pos++;
            } else if (nums[pos] == 2) {
                swap(nums, pos, r--);
            }
        }
    }

}
