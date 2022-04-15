package edu.zju.zjh.lc.dp;

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

    private int[] nums = new int[]{2, 3, 5};

    public int nthUglyNumber0(int n) {
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

    public static void main(String[] args) {
        System.out.println(new O0049().nthUglyNumber0(1));
        System.out.println(new O0049().nthUglyNumber(1));
        System.out.println(new O0049().nthUglyNumber0(71));
        System.out.println(new O0049().nthUglyNumber(71));
        System.out.println(new O0049().nthUglyNumber0(1407));
        System.out.println(new O0049().nthUglyNumber(1407));
    }

}
