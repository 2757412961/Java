package edu.zju.zjh.lc.game;

/**
 * @author: zjh
 * @date : 2022/5/19 15:59
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0486 {

    private int[][] memo;

    public int minmax(int[] nums, int l, int r, boolean isA) {
        if (memo[l][r] != 0) return memo[l][r];

        if (isA) {
            if (l == r) return nums[l];
            memo[l][r] = Math.max(
                    minmax(nums, l + 1, r, false) + nums[l],
                    minmax(nums, l, r - 1, false) + nums[r]
            );
        } else {
            if (l == r) return -nums[l];
            memo[l][r] = Math.min(
                    minmax(nums, l + 1, r, true) - nums[l],
                    minmax(nums, l, r - 1, true) - nums[r]
            );
        }

        return memo[l][r];
    }

    public boolean PredictTheWinner(int[] nums) {
        memo = new int[nums.length][nums.length];
        return minmax(nums, 0, nums.length - 1, true) >= 0;
    }

    public static void main(String[] args) {
        System.out.println(new Q0486().PredictTheWinner(new int[]{0, 0, 0}));
        System.out.println(new Q0486().PredictTheWinner(new int[]{1, 5, 2}));
        System.out.println(new Q0486().PredictTheWinner(new int[]{1, 5, 133, 7}));
    }

}
