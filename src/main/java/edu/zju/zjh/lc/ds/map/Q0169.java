package edu.zju.zjh.lc.ds.map;

/**
 * @author: zjh
 * @date : 2022/3/11 16:05
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0169 {

    public int majorityElement1(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count++;
            } else {
                if (candidate == nums[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        return candidate;
    }

    /**
     * 二刷
     * 方法五：Boyer-Moore 投票算法
     * 执行耗时:1 ms,击败了99.91% 的Java用户
     * 内存消耗:44.6 MB,击败了77.43% 的Java用户
     */
    public int majorityElement(int[] nums) {
        int count = 1, major = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                major = nums[i];
                count++;
            } else {
                if (nums[i] == major) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        return major;
    }

}
