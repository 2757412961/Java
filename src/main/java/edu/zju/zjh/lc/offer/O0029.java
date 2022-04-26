package edu.zju.zjh.lc.offer;

/**
 * @author: zjh
 * @date : 2022/4/26 13:57
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0029 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        int mn = m * n;
        int[] res = new int[mn];

        int cou = 0;
        int i = 0, j = 0;
        int left = 0, righ = n - 1;
        int top = 1, end = m - 1;
        while (cou < mn) {
            while (cou < mn && j <= righ) {
                res[cou++] =  matrix[i][j++];
            }
            i++; j = righ; righ--;
            while (cou < mn && i <= end){
                res[cou++] = matrix[i++][j];
            }
            j--; i = end; end--;
            while (cou < mn && j >= left){
                res[cou++] =  matrix[i][j--];
            }
            i--; j = left; left++;
            while (cou < mn && i >= top){
                res[cou++] =  matrix[i--][j];
            }
            j++; i = top; top++;
        }

        return res;
    }

}
