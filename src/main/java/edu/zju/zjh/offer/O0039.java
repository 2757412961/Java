package edu.zju.zjh.offer;

/**
 * @author: zjh
 * @date : 2022/4/8 下午 09:20
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0039 {

    public int majorityElement(int[] nums) {
        int res = nums[0], count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                res = nums[i];
            }
            if (res == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        return res;
    }

}
