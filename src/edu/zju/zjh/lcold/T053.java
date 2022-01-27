package edu.zju.zjh.lcold;

public class T053 {
    public int maxSubArray_violence(int[] nums) {
        int res = 0, sum = 0;
        int i = 0, j = 0, n = nums.length;

        for (; i < n; i++) {
            int sss = 0;
            for (j = i; j < n; j++) {
                sss += nums[j];
                if (sss > res) {
                    res = sss;
                }
            }
        }

        return res;
    }

    public int maxSubArray_greedy(int[] nums) {
        int res = nums[0], sum = 0;
        int i = 0, j = 0, n = nums.length;

        while (i < n) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            if (sum > res) {
                res = sum;
            }
            i++;
        }

        return res;
    }

    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(new T053().maxSubArray(nums));
        System.out.println(new T053().maxSubArray_greedy(nums));
        System.out.println(new T053().maxSubArray_violence(nums));
    }
}
