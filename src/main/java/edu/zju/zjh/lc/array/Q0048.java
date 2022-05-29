package edu.zju.zjh.lc.array;

/**
 * @author: zjh
 * @date : 2022/5/29 15:17
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0048 {

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.1 MB,击败了56.32% 的Java用户
     */
    public void swap(int[][] nums, int a, int b, int c, int d) {
        int temp = nums[a][b];
        nums[a][b] = nums[c][d];
        nums[c][d] = temp;
    }

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix[0] == null) return;
        int n = matrix.length;

        // 斜对角翻转
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(matrix, i, j, j, i);
            }
        }

        // 垂直翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                swap(matrix, i, j, i, n - 1 - j);
            }
        }
    }

}
