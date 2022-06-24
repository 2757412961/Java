package edu.zju.zjh.offer;

/**
 * @author: zjh
 * @date : 2022/3/9 17:20
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0004 {

    /**
     * 方法一：二分查找
     */
    private class S1 {

        public int binarySearch(int[] nums, int target) {
            int left = 0, right = nums.length, mid = 0;

            while (left < right) {
                mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid;
                } else if (nums[mid] == target) {
                    left = mid + 1;
                }
            }

            return left - 1;
        }

        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if (matrix.length <= 0 || matrix[0].length <= 0) return false;
            int[] colFirstArr = new int[matrix.length];
            int idx = -1;

            for (int i = 0; i < matrix.length; i++) {
                colFirstArr[i] = matrix[i][0];
            }

            idx = binarySearch(colFirstArr, target);

            for (; idx >= 0; idx--) {
                int col = binarySearch(matrix[idx], target);
                if (col < 0) {
                    continue;
                }
                if (matrix[idx][col] == target) {
                    return true;
                }
            }

            return false;
        }

    }

    /**
     * 方法二：线性查找
     */
    private class S2 {

        private boolean inBox(int[][] matrix, int x, int y) {
            if (matrix.length <= x) {
                return false;
            }
            if (y < 0) {
                return false;
            }

            return true;
        }

        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if (matrix.length <= 0 || matrix[0].length <= 0) return false;
            int i = 0, j = matrix[0].length - 1;

            while (inBox(matrix, i, j)) {
                if (matrix[i][j] == target) {
                    return true;
                } else if (matrix[i][j] < target) {
                    i++;
                } else if (matrix[i][j] > target) {
                    j--;
                }
            }

            return false;
        }

    }

}
