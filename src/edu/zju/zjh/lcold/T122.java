package edu.zju.zjh.lcold;

public class T122 {
    public int calMaxProfit(int[] prices, int index) {
        if (index >= prices.length) {
            return 0;
        }

        int max = 0;
        for (int j = index; j < prices.length; j++) {
            int maxpro = 0;
            for (int i = j + 1; i < prices.length; i++) {
                int profit = 0;
                if (prices[j] < prices[i]) {
                    profit = prices[i] - prices[j] + calMaxProfit(prices, i + 1);
                }

                if (profit > maxpro) {
                    maxpro = profit;
                }
            }

            if (maxpro > max) {
                max = maxpro;
            }
        }


        return max;
    }


    public int maxProfit_violence(int[] prices) {
        return calMaxProfit(prices, 0);
    }

    public int maxProfit_20200714(int[] prices) {
        int[] cash = new int[prices.length];
        int[] stoc = new int[prices.length];

        cash[0] = 0;
        stoc[0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            cash[i] = Math.max(cash[i - 1], stoc[i - 1] + prices[i]);
            stoc[i] = Math.max(stoc[i - 1], cash[i - 1] - prices[i]);

        }

        return cash[prices.length - 1];
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] buys = new int[n];
        int[] sell = new int[n];

        buys[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i < n; i++) {
            buys[i] = Math.max(buys[i - 1], sell[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buys[i - 1] + prices[i]);
        }

        return sell[n - 1];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3, 2, 6, 5, 0, 3};

        System.out.println(new T122().maxProfit(prices));
        System.out.println(new T122().maxProfit_20200714(prices));
        System.out.println(new T122().maxProfit_violence(prices));
    }
}
