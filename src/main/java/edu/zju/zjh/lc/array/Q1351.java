package edu.zju.zjh.lc.array;

/**
 * @author: zjh
 * @date : 2022/7/11 14:25
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q1351 {

    /**
     * 方法二：二分查找
     */

    /**
     * 方法四：倒序遍历
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.4 MB,击败了97.83% 的Java用户
     */
    private class S1 {

        public int countNegatives(int[][] grid) {
            int res = 0;
            int m = grid.length, n = grid[0].length;
            int i = m - 1, j = 0;

            while (i >= 0) {
                while (j < n && grid[i][j] >= 0) {
                    j++;
                }

                res += n - j;
                i--;
            }

            return res;
        }

    }

}
