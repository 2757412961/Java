package edu.zju.zjh.lc.array;

/**
 * @author: zjh
 * @date : 2022/7/17 20:48
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0073 {

    /**
     * 方法一：使用标记数组
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:43.2 MB,击败了19.69% 的Java用户
     */
    private class S1 {

        public void setZeroes(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            boolean[] row = new boolean[m];
            boolean[] col = new boolean[n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        row[i] = col[j] = true;
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (row[i] || col[j]) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

    }

}
