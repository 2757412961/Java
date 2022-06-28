package edu.zju.zjh.lc.dp;

/**
 * @author: zjh
 * @date : 2022/6/28 16:36
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0746 {

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.2 MB,击败了21.31% 的Java用户
     */
    public int minCostClimbingStairs(int[] cost) {
        int a = 0, b = 0, c = 0;

        for (int i = 0; i < cost.length; i++) {
            c = cost[i] + Math.min(a, b);
            a = b;
            b = c;
        }

        return Math.min(a, b);
    }

}
