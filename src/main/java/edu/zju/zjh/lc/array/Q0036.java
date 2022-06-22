package edu.zju.zjh.lc.array;

/**
 * @author: zjh
 * @date : 2022/6/22 下午 07:47
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0036 {

    /**
     * 方法一：一次遍历
     * 执行耗时:1 ms,击败了99.43% 的Java用户
     * 内存消耗:41.7 MB,击败了10.97% 的Java用户
     */
    private class S1 {

        public boolean isValidSudoku(char[][] board) {
            int[][] rows = new int[9][9];
            int[][] cols = new int[9][9];
            int[][][] boxes = new int[3][3][9];

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        int num = board[i][j] - '0' - 1;
                        rows[i][num]++;
                        cols[j][num]++;
                        boxes[i / 3][j / 3][num]++;
                        if (rows[i][num] > 1 || cols[j][num] > 1 || boxes[i / 3][j / 3][num] > 1) {
                            return false;
                        }
                    }
                }
            }

            return true;
        }

    }

}
