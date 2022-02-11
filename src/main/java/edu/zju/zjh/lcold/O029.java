package main.java.edu.zju.zjh.lcold;

import java.util.Arrays;

public class O029 {

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

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

        System.out.println(Arrays.toString(new O029().spiralOrder(matrix)));
    }
}
