package edu.zju.zjh.lcold;

public class T221 {

    public int maximalSquare_before(char[][] matrix) {
        int m = matrix.length;
        if (m <= 0) return 0;
        int n = matrix[0].length;
        int maxD = 0;

        int[][] digui = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    digui[i][j] = 1 + Math.min(Math.min(digui[i - 1][j - 1], digui[i - 1][j]), digui[i][j - 1]);
                    maxD = Math.max(maxD, digui[i][j]);
                }
            }
        }

        return maxD * maxD;
    }

    public int maximalSquare(int[][] matrix) {
        if (matrix.length <= 0) {
            return 0;
        }
        int res = 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (matrix[i - 1][j - 1] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    res = Math.max(dp[i][j], res);
                }
            }
        }

        return res * res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };

        System.out.println(new T221().maximalSquare(matrix));
    }
}
