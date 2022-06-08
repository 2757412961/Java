package edu.zju.zjh.lc.array;

/**
 * @author: zjh
 * @date : 2022/6/8 20:30
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0283 {

    /**
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:42.8 MB,击败了38.63% 的Java用户
     */
    public void moveZeroes(int[] nums) {
        int l = 0, idx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[l++] = nums[i];
            }
        }

        for (int i = l; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}
