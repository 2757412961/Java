package edu.zju.zjh.lc.backtrack;

/**
 * @author: zjh
 * @date : 2022/6/2 21:03
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0079 {

    /**
     * 执行耗时:79 ms,击败了83.50% 的Java用户
     * 内存消耗:39.3 MB,击败了82.89% 的Java用户
     */
    public boolean exist(char[][] board, boolean[][] vised, int i, int j, char[] words, int idx) {
        if (idx == words.length) return true;
        if (i < 0 || i >= board.length) return false;
        if (j < 0 || j >= board[0].length) return false;
        if (vised[i][j]) return false;
        if (board[i][j] != words[idx++]) return false;

        boolean res = true;
        vised[i][j] = true;
        res = exist(board, vised, i + 1, j, words, idx) ||
                exist(board, vised, i - 1, j, words, idx) ||
                exist(board, vised, i, j + 1, words, idx) ||
                exist(board, vised, i, j - 1, words, idx);
        vised[i][j] = false;

        return res;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        char[] words = word.toCharArray();
        boolean[][] vised = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (exist(board, vised, i, j, words, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

}
