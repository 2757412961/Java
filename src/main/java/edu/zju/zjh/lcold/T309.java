package main.java.edu.zju.zjh.lcold;

public class T309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] buys = new int[n];
        int[] sell = new int[n];

        if (n <= 0) return 0;

        buys[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i < n; i++) {
            buys[i] = Math.max(
                    buys[i - 1],
                    Math.min(sell[i - 1], sell[i - 2 < 0 ? 0 : i - 2]) - prices[i]
            );
            sell[i] = Math.max(sell[i - 1], buys[i - 1] + prices[i]);
        }

        return sell[n - 1];
    }

    public static void main(String[] args) {
//        int[] prices = new int[]{1, 2, 3, 0, 2};
        int[] prices = new int[]{1, 2};

        System.out.println(new T309().maxProfit(prices));
    }
}
