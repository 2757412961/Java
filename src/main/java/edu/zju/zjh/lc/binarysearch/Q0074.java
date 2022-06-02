package edu.zju.zjh.lc.binarysearch;

/**
 * @author: zjh
 * @date : 2022/6/2 20:55
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0074 {

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.3 MB,击败了11.13% 的Java用户
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int l, r, m, i;

        l = 0;
        r = matrix.length;
        while (l < r) {
            m = l + (r - l) / 2;
            if (matrix[m][0] == target) {
                return true;
            } else if (matrix[m][0] > target) {
                r = m;
            } else if (matrix[m][0] < target) {
                l = m + 1;
            }
        }
        if (l == 0) {
            return false;
        }

        i = l - 1;
        l = 0;
        r = matrix[i].length;
        while (l < r) {
            m = l + (r - l) / 2;
            if (matrix[i][m] == target) {
                return true;
            } else if (matrix[i][m] > target) {
                r = m;
            } else if (matrix[i][m] < target) {
                l = m + 1;
            }
        }

        return false;
    }

}
