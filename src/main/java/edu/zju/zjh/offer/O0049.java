package edu.zju.zjh.offer;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @author: zjh
 * @date : 2022/4/14 下午 08:27
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0049 {

    /**
     * 方法一：最小堆
     * 执行耗时:50 ms,击败了12.22% 的Java用户
     * 内存消耗:41.2 MB,击败了10.74% 的Java用户
     */
    private class S1 {

        private int[] nums = new int[]{2, 3, 5};

        public int nthUglyNumber(int n) {
            int res = 1;
            long num = -1;
            Set<Long> set = new HashSet<>();
            Queue<Long> que = new PriorityQueue<>();
            set.add(1L);
            que.offer(1L);

            while (n > 0) {
                long cur = que.poll();
                res = (int) cur;
                for (int i = 0; i < nums.length; i++) {
                    num = cur * nums[i];
                    if (!set.contains(num)) {
                        set.add(num);
                        que.offer(num);
                    }
                }
                n--;
            }

            return res;
        }

    }

    /**
     * 方法二：动态规划
     * 执行耗时:2 ms,击败了98.37% 的Java用户
     * 内存消耗:39.2 MB,击败了82.91% 的Java用户
     */
    private class S2 {

        public int nthUglyNumber(int n) {
            if (n < 1) return 0;
            int res = 1;
            int[] dp = new int[n + 1];
            dp[1] = 1;
            int p2 = 1, p3 = 1, p5 = 1;

            for (int i = 2; i <= n; i++) {
                long num2 = dp[p2] * 2L;
                long num3 = dp[p3] * 3L;
                long num5 = dp[p5] * 5L;
                long next = Math.min(Math.min(num2, num3), num5);
                if (num2 == next) {
                    p2++;
                }
                if (num3 == next) {
                    p3++;
                }
                if (num5 == next) {
                    p5++;
                }

                dp[i] = (int) next;
            }

            return dp[n];
        }

    }

    /**
     * 二刷
     * 执行耗时:2 ms,击败了98.37% 的Java用户
     * 内存消耗:39.7 MB,击败了38.56% 的Java用户
     */
    private class S3 {

        public int min(int x, int y, int z) {
            return Math.min(Math.min(x, y), z);
        }

        public int nthUglyNumber(int n) {
            int[] dp = new int[n + 1];
            int p2 = 1, p3 = 1, p5 = 1;

            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                int dp2 = dp[p2] * 2;
                int dp3 = dp[p3] * 3;
                int dp5 = dp[p5] * 5;
                int min = min(dp2, dp3, dp5);
                dp[i] = min;

                if (min == dp2) p2++;
                if (min == dp3) p3++;
                if (min == dp5) p5++;
            }

            return dp[n];
        }

    }

    public static void main(String[] args) {
        System.out.println(new O0049().new S1().nthUglyNumber(1));
        System.out.println(new O0049().new S1().nthUglyNumber(71));
        System.out.println(new O0049().new S1().nthUglyNumber(1407));

        System.out.println(new O0049().new S2().nthUglyNumber(1));
        System.out.println(new O0049().new S2().nthUglyNumber(71));
        System.out.println(new O0049().new S2().nthUglyNumber(1407));

        System.out.println(new O0049().new S3().nthUglyNumber(1));
        System.out.println(new O0049().new S3().nthUglyNumber(71));
        System.out.println(new O0049().new S3().nthUglyNumber(1407));
    }

}
