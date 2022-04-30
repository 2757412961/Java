package edu.zju.zjh.lc.dp.rob;

/**
 * @author: zjh
 * @date : 2022/4/30 10:01
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0213 {

    public int rob(int[] nums, int start, int end) {
        int before = 0, prev = 0, now = 0;

        for (int i = start; i <= end; i++) {
            now = Math.max(prev, before + nums[i]);
            before = prev;
            prev = now;
        }

        return now;
    }

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int n = nums.length;

        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }

    public static void main(String[] args) {
        System.out.println(new Q0213().rob(new int[]{1}));
        System.out.println(new Q0213().rob(new int[]{1, 2, 3}));
        System.out.println(new Q0213().rob(new int[]{1, 2, 3, 1}));
    }

}
