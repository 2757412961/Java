package edu.zju.zjh.lc.array;

/**
 * @author: zjh
 * @date : 2022/7/12 21:48
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0566 {

    class Solution {
        public int[][] matrixReshape(int[][] nums, int r, int c) {
            int m = nums.length;
            int n = nums[0].length;
            if (m * n != r * c) {
                return nums;
            }

            int[][] ans = new int[r][c];
            for (int x = 0; x < m * n; ++x) {
                ans[x / c][x % c] = nums[x / n][x % n];
            }
            return ans;
        }
    }

}
