package edu.zju.zjh.lc.offer;

import java.util.Arrays;

/**
 * @author: zjh
 * @date : 2022/4/22 10:16
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0060 {

    private double[][] memo;

    public double dp(int n, int x) {
        if (n == 1) return 1.0 / 6.0;
        if (memo[n][x] > 0) return memo[n][x];
        double res = 0;

        int min = n - 1, max = 6 * min;
        for (int i = 1; i <= 6; i++) {
            int last = x - i;
            if (min <= last && last <= max) {
                res += dp(n - 1, last);
            }
        }
        memo[n][x] = res / 6.0;

        return memo[n][x];
    }

    public double[] dicesProbability(int n) {
        int start = n, end = 6 * n + 1;
        double[] res = new double[5 * n + 1];
        memo = new double[n + 1][end];

        int idx = 0;
        while (idx < res.length) {
            res[idx] = dp(n, idx + n);
            idx++;
        }

        return res;
    }

    public static void main(String[] args) {
        Arrays.stream(new O0060().dicesProbability(6)).forEach(System.out::println);
    }

}
