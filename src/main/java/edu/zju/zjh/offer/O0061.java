package edu.zju.zjh.offer;

import java.util.Arrays;

/**
 * @author: zjh
 * @date : 2022/4/23 下午 08:26
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0061 {

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int count = 0, sum = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                int a = nums[i + 1] - nums[i] - 1;
                if (a<0) return false;
                sum += a;
            }
        }

        return count == sum;
    }

}
