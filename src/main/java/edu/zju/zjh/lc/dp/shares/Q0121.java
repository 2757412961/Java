package edu.zju.zjh.lc.dp.shares;

/**
 * @author: zjh
 * @date : 2022/4/24 20:31
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0121 {

    /**
     * 方法一：暴力法
     */

    /**
     * 方法二：动态规划
     * 执行耗时:2 ms,击败了58.51% 的Java用户
     * 内存消耗:57.7 MB,击败了30.17% 的Java用户
     */
    private class S1 {

        public int maxProfit(int[] prices) {
            if (prices.length == 0) return 0;
            int min = prices[0], res = 0;

            for (int i = 1; i < prices.length; i++) {
                if (min > prices[i]) {
                    min = prices[i];
                }
                if (res < prices[i] - min) {
                    res = prices[i] - min;
                }
            }

            return res;
        }

    }

    /**
     * 方法三：一次遍历
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:57.4 MB,击败了62.73% 的Java用户
     */
    private class S2 {

        public int maxProfit(int[] prices) {
            int res = 0, min = Integer.MAX_VALUE;

            for (int i = 0; i < prices.length; i++) {
                min = Math.min(min, prices[i]);
                res = Math.max(res, prices[i] - min);
            }

            return res;
        }

    }

}
