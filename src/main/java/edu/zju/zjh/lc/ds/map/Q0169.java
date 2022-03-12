package edu.zju.zjh.lc.ds.map;

/**
 * @author: zjh
 * @date : 2022/3/11 16:05
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0169 {

    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0){
                candidate = nums[i];
                count++;
            } else {
                if (candidate == nums[i]){
                    count++;
                } else {
                    count--;
                }
            }
        }

        return candidate;
    }

}
