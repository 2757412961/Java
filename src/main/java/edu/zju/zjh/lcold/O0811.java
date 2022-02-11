package main.java.edu.zju.zjh.lcold;

public class O0811 {
    public int waysToChange_violence(int n) {
        int res = 0;

        for (int i = 0; i <= n / 25; i++) {
            for (int j = 0; j <= (n - 25 * i) / 10; j++) {
                for (int k = 0; k <= (n - 25 * i - 10 * j) / 5; k++) {
                    if (n - 25 * i - 10 * j - 5 * k >= 0) {
                        res++;
                        res %= 1000000007;
                    }
                }
            }
        }

        return res;
    }

    public int waysToChange(int n) {
        int[] coins = new int[]{1, 5, 10, 25};
        if (n < 5) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        O0811 o0811 = new O0811();
        System.out.println(o0811.waysToChange(900750));
        System.out.println(o0811.waysToChange_violence(30));
    }
}
