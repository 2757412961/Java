package edu.zju.zjh.lc.dp.subsequence;

/**
 * @author: zjh
 * @date : 2022/4/11 下午 02:07
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0300 {

    /**
     * 方法一：动态规划 时间复杂度：O(n^2)
     * <p>
     * 执行耗时:57 ms,击败了33.37% 的Java用户
     * 内存消耗:41.3 MB,击败了5.14% 的Java用户
     */
    public int lengthOfLISDP(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    /**
     * 方法二：贪心 + 二分查找 时间复杂度：O(nlogn)
     * 考虑一个简单的贪心，如果我们要使上升子序列尽可能的长，则我们需要让序列上升得尽可能慢，因此我们希望每次在上升子序列最后加上的那个数尽可能的小。
     * <p>
     * 执行耗时:3 ms,击败了81.34% 的Java用户
     * 内存消耗:41.2 MB,击败了9.21% 的Java用户
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, len = 0;
        int[] d = new int[n];
        d[0] = nums[0];

        for (int i = 1; i < n; i++) {
            if (d[len] < nums[i]) {
                d[++len] = nums[i];
            } else {
                int l = 0, r = len + 1, m;
                while (l < r) {
                    m = l + (r - l) / 2;
                    if (d[m] == nums[i]) {
                        r = m;
                    } else if (d[m] > nums[i]) {
                        r = m;
                    } else if (d[m] < nums[i]) {
                        l = m + 1;
                    }
                }
                d[l] = nums[i];
            }
        }

        return len + 1;
    }

}
