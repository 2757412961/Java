package edu.zju.zjh.lc.offer;

/**
 * @author: zjh
 * @date : 2022/3/9 17:20
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0004 {

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

    public static void main(String[] args) {
        System.out.println(new O0004().binarySearch(new int[]{0, 1, 2, 2, 4, 5}, -3));
        System.out.println(new O0004().binarySearch(new int[]{0, 1, 2, 2, 4, 5}, 3));
        System.out.println(new O0004().binarySearch(new int[]{0, 1, 2, 2, 4, 5}, 4));
        System.out.println(new O0004().binarySearch(new int[]{0, 1, 2, 2, 4, 5}, 9));
        System.out.println(new O0004().findNumberIn2DArray(new int[0][0], 1));
    }

}
