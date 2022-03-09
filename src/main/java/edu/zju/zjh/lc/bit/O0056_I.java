package edu.zju.zjh.lc.bit;

/**
 * @author: zjh
 * @date : 2022/3/9 10:41
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0056_I {

    public int[] singleNumbers(int[] nums) {
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
