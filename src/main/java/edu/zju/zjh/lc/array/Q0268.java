package edu.zju.zjh.lc.array;

/**
 * @author: zjh
 * @date : 2022/3/22 下午 04:09
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0268 {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int[] used = new int[n + 1];

        for (int i = 0; i < n; i++) {
            used[nums[i]] = 1;
        }

        for (int i = 0; i <= n; i++) {
            if (used[i] == 0) {
                return i;
            }
        }

        return -1;
    }

}
