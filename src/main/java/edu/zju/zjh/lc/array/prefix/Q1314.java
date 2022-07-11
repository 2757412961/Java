package edu.zju.zjh.lc.array.prefix;

/**
 * @author: zjh
 * @date : 2022/7/10 21:08
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q1314 {

    /**
     * 方法一：二维前缀和
     * 执行耗时:4 ms,击败了74.26% 的Java用户
     * 内存消耗:42.1 MB,击败了49.84% 的Java用户
     */
    private class S1 {

        public int[][] matrixBlockSum(int[][] mat, int k) {
            int m = mat.length, n = mat[0].length;
            int[][] pre = new int[m + 1][n + 1];
            int[][] res = new int[m][n];

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    pre[i][j] = mat[i - 1][j - 1] + pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1];
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int minx = Math.max(0, i - k);
                    int miny = Math.max(0, j - k);
                    int maxx = Math.min(m - 1, i + k) + 1;
                    int maxy = Math.min(n - 1, j + k) + 1;

                    res[i][j] = pre[maxx][maxy] - pre[minx][maxy] - pre[maxx][miny] + pre[minx][miny];
                }
            }

            return res;
        }

    }

}
