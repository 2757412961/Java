package main.java.edu.zju.zjh.lcold;

import java.util.ArrayList;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/8/2 下午 10:17
 * @Modified_By :
 */
public class T329 {
    int[] used = null;

    public int dfs(ArrayList<Integer>[] paths, int sta, int depth) {
        int len = 0;
        used[sta] = 1;

        for (int i = 0; i < paths[sta].size(); i++) {
            if (used[paths[sta].get(i)] == 0) {
                len = Math.max(len, dfs(paths, paths[sta].get(i), 0));

            }
        }

        used[sta] = 0;

        return len + 1;
    }

    public int longestIncreasingPath_violence(int[][] matrix) {
        if (matrix.length <= 0) return 0;
        int res = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int mn = m * n;
        int[] ids = new int[mn];
        ArrayList<Integer>[] paths = new ArrayList[mn];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int id = i * n + j;
                ids[id] = id;
                paths[id] = new ArrayList<>();

                if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
                    paths[id].add((i - 1) * n + j);
                }
                if (i + 1 < m && matrix[i + 1][j] > matrix[i][j]) {
                    paths[id].add((i + 1) * n + j);
                }
                if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
                    paths[id].add(i * n + (j - 1));
                }
                if (j + 1 < n && matrix[i][j + 1] > matrix[i][j]) {
                    paths[id].add(i * n + (j + 1));
                }
            }
        }

        for (int i = 0; i < mn; i++) {
            used = new int[mn];
            used[i] = 1;

            res = Math.max(res, dfs(paths, i, 1));
        }


        return res;
    }

    public int memodfs(int[][] matrix, int[][] memo, int x, int y) {
        if (memo[x][y] != 0) {
            return memo[x][y];
        }

        int len = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < dirs.length; i++) {
            int nx = x + dirs[i][0];
            int ny = y + dirs[i][1];

            if (0 <= nx && nx < m && 0 <= ny && ny < n && matrix[x][y] < matrix[nx][ny]) {
                len = Math.max(len, memodfs(matrix, memo, nx, ny));
            }
        }

        memo[x][y] = len + 1;
        return memo[x][y];
    }

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length <= 0) return 0;
        int res = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                res = Math.max(res, memodfs(matrix, memo, i, j));
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        给定一个整数矩阵，找出最长递增路径的长度。
//        对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
//
//        示例 1:
//        输入: nums =
//        [
//          [9,9,4],
//          [6,6,8],
//          [2,1,1]
//        ]
//        输出: 4
//        解释: 最长递增路径为 [1, 2, 6, 9]。
//
//        示例 2:
//        输入: nums =
//        [
//          [3,4,5],
//          [3,2,6],
//          [2,2,1]
//        ]
//        输出: 4
//        解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。

//        int[][] matrix = new int[][]{
//                {3, 4, 5},
//                {3, 2, 6},
//                {2, 2, 1}
//        };
        int[][] matrix = new int[][]{
                {7, 8, 9},
                {9, 7, 6},
                {7, 2, 3}
        };

        System.out.println(new T329().longestIncreasingPath(matrix));
        System.out.println(new T329().longestIncreasingPath_violence(matrix));
    }
}
