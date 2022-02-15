package edu.zju.zjh.lcold;

public class O0801 {
    public int waysToStep(int n) {
        int m = n < 4 ? 4 : n;
        long[] dp = new long[m + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= m; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            dp[i] %= 1000000007;
        }

        return (int)dp[n];
    }

    public static void main(String[] args) {
        O0801 o0801 = new O0801();
        System.out.println(o0801.waysToStep(3));
    }
}
