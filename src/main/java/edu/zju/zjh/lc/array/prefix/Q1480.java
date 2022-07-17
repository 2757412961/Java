package edu.zju.zjh.lc.array.prefix;

/**
 * @author: zjh
 * @date : 2022/7/17 21:16
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q1480 {

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.3 MB,击败了63.23% 的Java用户
     */
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        res[0] = nums[0];
        for (int i = 1; i < n; i++) {
            res[i] += res[i - 1] + nums[i];
        }

        return res;
    }

}
