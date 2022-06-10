package edu.zju.zjh.lc.dp.subsequence;

/**
 * @author: zjh
 * @date : 2022/4/12 上午 11:44
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0053 {

    /**
     * 贪心算法
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:50.4 MB,击败了72.19% 的Java用户
     */
    public int maxSubArrayGreedy(int[] nums) {
        int res = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(0, sum);
            sum += nums[i];
            res = Math.max(res, sum);
        }

        return res;
    }

    /**
     * 动态规划
     * 执行耗时:2 ms,击败了36.74% 的Java用户
     * 内存消耗:50.7 MB,击败了31.37% 的Java用户
     */
    public int maxSubArrayDP(int[] nums) {
        int res = Integer.MIN_VALUE;
        int n = nums.length;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i - 1], nums[i - 1]);
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    /**
     * 分治算法
     */
    public int maxSubArrayDC(int[] nums) {
        // todo
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new edu.zju.zjh.lc.dp.subsequence.Q0053().maxSubArrayGreedy(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(new edu.zju.zjh.lc.dp.subsequence.Q0053().maxSubArrayDP(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(new edu.zju.zjh.lc.dp.subsequence.Q0053().maxSubArrayDC(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

}
