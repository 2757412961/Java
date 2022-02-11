package main.java.edu.zju.zjh.lcold;

public class T085 {
    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        if (matrix.length <= 0) {
            return res;
        }

        int maxw = 0, maxh = 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = dp[i][j - 1] + 1;

                    maxw = dp[i][j];

                    for (int k = i; k >= 1; k--) {
                        if (maxw > 0) {
                            maxw = Math.min(maxw, dp[k][j]);
                            maxh = i - k + 1;

                            res = Math.max(res, maxw * maxh);
                        }
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        System.out.println(new T085().maximalRectangle(matrix));
    }
}
