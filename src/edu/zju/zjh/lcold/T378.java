package edu.zju.zjh.lcold;

import java.util.Arrays;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/7/2 上午 10:23
 * @Modified_By :
 */
public class T378 {

    public int kthSmallest_oficial(int[][] matrix, int k) {
        int rows = matrix.length, columns = matrix[0].length;
        int[] sorted = new int[rows * columns];
        int index = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                sorted[index++] = num;
            }
        }
        Arrays.sort(sorted);
        return sorted[k - 1];
    }

    public int kthSmallest(int[][] matrix, int k) {
        int res = matrix[0][0];
        int n = matrix.length;
        int m = matrix[0].length;
        int[] index = new int[n];

        while (k > 0) {
            int min = Integer.MAX_VALUE;
            int minIndex = m;

            for (int i = 0; i < n; i++) {
                int j = index[i];
                if (j < m && matrix[i][j] < min) {
                    min = matrix[i][j];
                    minIndex = i;
                }
            }

            res = min;
            index[minIndex]++;
            k--;
        }

        return res;
    }

    public static void main(String[] args) {
//        给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
//
//        示例：
//        matrix = [
//                   [ 1,  5,  9],
//                   [10, 11, 13],
//                   [12, 13, 15]
//                ],
//        k = 8, 返回 13。
//
//        int[][] matrix = new int[][]{
//                {1, 5, 9},
//                {10, 11, 13},
//                {12, 13, 15}
//        };
//        int k = 8;

        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int k = 5;

        System.out.println(new T378().kthSmallest(matrix, k));
        System.out.println(new T378().kthSmallest_oficial(matrix, k));
    }
}
