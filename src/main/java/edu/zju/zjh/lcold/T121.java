package main.java.edu.zju.zjh.lcold;

public class T121 {
    public int maxProfit_violence(int[] prices) {
        int res = 0;
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                res = Math.max(res, prices[j] - prices[i]);
            }
        }

        return res;
    }

    public int maxProfit(int[] prices) {
        int res = 0;
        int[] dp = new int[prices.length];

        return res;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};

        System.out.println(new T121().maxProfit(prices));
        System.out.println(new T121().maxProfit_violence(prices));
    }
}
