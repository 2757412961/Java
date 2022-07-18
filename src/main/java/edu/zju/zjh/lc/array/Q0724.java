package edu.zju.zjh.lc.array;

/**
 * @author: zjh
 * @date : 2022/7/17 21:51
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0724 {

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.2 MB,击败了5.39% 的Java用户
     */
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prel = new int[n];
        int[] prer = new int[n];

        for (int i = 1; i < n; i++) {
            prel[i] = prel[i - 1] + nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            prer[i] = prer[i + 1] + nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            if (prel[i] == prer[i]) {
                return i;
            }
        }

        return -1;
    }

}
