package edu.zju.zjh.topk.pingcap;

import java.util.Arrays;

/**
 * @author: zjh
 * @date : 2022/5/23 17:04
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0061 {

    public boolean isStraight(int[] nums) {
        int countW = 0;
        Arrays.sort(nums);

        int last = nums[4];
        if (last == 0) {
            return true;
        }

        for (int i = 3; i >= 0; i--) {
            if (nums[i] == 0) {
                countW++;
            } else if (--last != nums[i]) {
                if (nums[i] == nums[i + 1]) {
                    return false;
                }

                countW -= last - nums[i];
                last = nums[i];
            }
        }

        return countW >= 0;
    }

}
