package edu.zju.zjh.lc.array;

/**
 * @author: zjh
 * @date : 2022/4/13 下午 07:34
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;

        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] < target) {
                i++;
            } else if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] == target) {
                return true;
            }
        }

        return false;
    }

}
