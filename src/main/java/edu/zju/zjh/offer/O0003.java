package edu.zju.zjh.offer;

/**
 * @author: zjh
 * @date : 2022/3/9 16:22
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0003 {

    public int findRepeatNumber(int[] nums) {
        boolean[] used = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (used[nums[i]]) {
                return nums[i];
            } else {
                used[nums[i]] = true;
            }
        }

        return -1;
    }

}
