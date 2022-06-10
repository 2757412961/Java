package edu.zju.zjh.offer;

/**
 * @author: zjh
 * @date : 2022/4/15 下午 03:25
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0053_II {

    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }

        return nums.length;
    }

}
