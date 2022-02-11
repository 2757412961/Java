package main.java.edu.zju.zjh.lcold;

public class T062 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][1] = 1;

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        System.out.println(new T062().uniquePaths(m, n));
    }
}
