package main.java.edu.zju.zjh.lcold;

import java.util.*;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/6/23 下午 04:09
 * @Modified_By :
 */
public class T054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length <= 0) return new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int mn = m * n;
        Integer[] res = new Integer[mn];

        int count = 0, i = 0, j = 0;
        int left = 0, righ = n - 1, top = 0, bot = m - 1;
        while (count < mn) {
            while (count < mn && j <= righ) {
                res[count++] = matrix[i][j++];
            }
            top++;
            i++;
            j = righ;

            while (count < mn && i <= bot) {
                res[count++] = matrix[i++][j];
            }
            righ--;
            i = bot;
            j--;

            while (count < mn && j >= left) {
                res[count++] = matrix[i][j--];
            }
            bot--;
            i--;
            j = left;

            while (count < mn && i >= top) {
                res[count++] = matrix[i--][j];
            }
            left++;
            i = top;
            j++;
        }


        return Arrays.asList(res);
    }

    public static void main(String[] args) {
//        给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
//
//        示例 1://
//        输入:
//        [
//         [ 1, 2, 3 ],
//         [ 4, 5, 6 ],
//         [ 7, 8, 9 ]
//        ]
//        输出: [1,2,3,6,9,8,7,4,5]

//        示例 2:
//
//        输入:
//        [
//          [1, 2, 3, 4],
//          [5, 6, 7, 8],
//          [9,10,11,12]
//        ]
//        输出: [1,2,3,4,8,12,11,10,9,5,6,7]

        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        System.out.println(new T054().spiralOrder(matrix));
    }
}
