package edu.zju.zjh.lc.dp.shares;

/**
 * @author: zjh
 * @date : 2022/4/24 20:31
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0121 {

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
