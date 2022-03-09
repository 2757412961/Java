package edu.zju.zjh.lc.bit;

/**
 * @author: zjh
 * @date : 2022/3/9 11:08
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0260 {

    public int[] singleNumber(int[] nums) {
        int x = 0, y = 0, xy = 0, split = 1;

        for (int i = 0; i < nums.length; i++) {
            xy ^= nums[i];
        }

        while ((xy & split) == 0) {
            split <<= 1;
        }

        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & split) == 0) {
                x ^= nums[i];
            } else {
                y ^= nums[i];
            }
        }

        return new int[]{x, y};
    }

}
