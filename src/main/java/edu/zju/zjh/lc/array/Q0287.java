package edu.zju.zjh.lc.array;

/**
 * @author: zjh
 * @date : 2022/6/8 20:36
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0287 {

    /**
     * 执行耗时:4 ms,击败了93.07% 的Java用户
     * 内存消耗:58.9 MB,击败了17.30% 的Java用户
     */
    public int findDuplicate(int[] nums) {
        int s = 0, f = 0;

        do {
            s = nums[s];
            f = nums[nums[f]];
        } while (nums[s] != nums[f]);

        s = 0;
        while (nums[s] != nums[f]) {
            s = nums[s];
            f = nums[f];
        }

        return nums[s];
    }

}
