package main.java.edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.List;

public class T120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int res = Integer.MAX_VALUE;
        int n = triangle.size();

        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            dp[i][0] = triangle.get(i).get(0) + dp[i - 1][0];
            dp[i][i] = triangle.get(i).get(i) + dp[i - 1][i - 1];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i; j++) {
                int val = triangle.get(i).get(j);
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + val;
            }
        }

        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[n - 1][i]);
        }

        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> ts;

        ts = new ArrayList<>();
        ts.add(2);
        triangle.add(ts);

        ts = new ArrayList<>();
        ts.add(3);
        ts.add(4);
        triangle.add(ts);

        ts = new ArrayList<>();
        ts.add(6);
        ts.add(5);
        ts.add(7);
        triangle.add(ts);

        ts = new ArrayList<>();
        ts.add(4);
        ts.add(1);
        ts.add(8);
        ts.add(3);
        triangle.add(ts);

        System.out.println(new T120().minimumTotal(triangle));
    }
}
