package edu.zju.zjh.lc.dp;

/**
 * @author: zjh
 * @date : 2022/7/5 14:43
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0096 {

    /**
     * 方法一：动态规划
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.1 MB,击败了60.15% 的Java用户
     */
    private class S1 {

        private int[] memo;

        public int dp(int n) {
            if (memo[n] != 0) return memo[n];

            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += dp(i - 1) * dp(n - i);
            }

            memo[n] = sum;
            return sum;
        }

        public int numTrees(int n) {
            if (n < 2) return n;
            memo = new int[n + 1];
            memo[0] = 1;
            memo[1] = 1;

            return dp(n);
        }

    }

    /**
     * 方法二：数学
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/unique-binary-search-trees/solution/bu-tong-de-er-cha-sou-suo-shu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private class S2 {

        class Solution {
            public int numTrees(int n) {
                int[] G = new int[n + 1];
                G[0] = 1;
                G[1] = 1;

                for (int i = 2; i <= n; ++i) {
                    for (int j = 1; j <= i; ++j) {
                        G[i] += G[j - 1] * G[i - j];
                    }
                }
                return G[n];
            }
        }

    }

    /**
     * 枚举
     */
    private class S3 {

        public int numTrees(int n) {
            switch (n) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 5;
                case 4:
                    return 14;
                case 5:
                    return 42;
                case 6:
                    return 132;
                case 7:
                    return 429;
                case 8:
                    return 1430;
                case 9:
                    return 4862;
                case 10:
                    return 16796;
                case 11:
                    return 58786;
                case 12:
                    return 208012;
                case 13:
                    return 742900;
                case 14:
                    return 2674440;
                case 15:
                    return 9694845;
                case 16:
                    return 35357670;
                case 17:
                    return 129644790;
                case 18:
                    return 477638700;
                case 19:
                    return 1767263190;
                default:
                    return 0;
            }
        }

    }

}