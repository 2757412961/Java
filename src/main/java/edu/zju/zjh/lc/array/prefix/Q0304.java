package edu.zju.zjh.lc.array.prefix;

/**
 * @author: zjh
 * @date : 2022/7/12 15:10
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0304 {

    /**
     * 方法一：一维前缀和
     */

    /**
     * 方法二：二维前缀和
     * 执行耗时:98 ms,击败了98.74% 的Java用户
     * 内存消耗:67.5 MB,击败了5.02% 的Java用户
     */
    class NumMatrix {

        private int[][] pre;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            pre = new int[m + 1][n + 1];

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    pre[i][j] = matrix[i - 1][j - 1] + pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            row2 += 1;
            col2 += 1;
            return pre[row2][col2] - pre[row1][col2] - pre[row2][col1] + pre[row1][col1];
        }

    }

}
