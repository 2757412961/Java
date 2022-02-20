package edu.zju.zjh.lc.oqpd;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zjh
 * @date : 2022/2/15 21:03
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q1380 {

    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        int[] rowMin = new int[m];
        int[] colMax = new int[n];

        for (int i = 0; i < m; i++) {
            rowMin[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                rowMin[i] = Math.min(matrix[i][j], rowMin[i]);
            }
        }

        for (int j = 0; j < n; j++) {
            colMax[j] = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                colMax[j] = Math.max(matrix[i][j], colMax[j]);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rowMin[i] == colMax[j]) {
                    res.add(rowMin[i]);
                }
            }
        }

        return res;
    }

    /**
     * 输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
     * 输出：[12]
     * 解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrix = new int[][]{new int[]{1, 10, 4, 2}, new int[]{9, 3, 8, 7}, new int[]{15, 16, 17, 12}};

        new Q1380().luckyNumbers(matrix).forEach(System.out::println);
    }

}
