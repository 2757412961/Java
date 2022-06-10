package edu.zju.zjh.offer;

/**
 * @author: zjh
 * @date : 2022/3/12 10:44
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0012 {

    private boolean res = false;
    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    private boolean inBox(int m, int n, int i, int j) {
        if (i < 0 || i >= m) return false;
        if (j < 0 || j >= n) return false;
        return true;
    }

    public boolean exist(char[][] board, int x, int y, String word, int idx, boolean[][] used) {
        if (res) return true;
        if (used[x][y]) return false;
        if (board[x][y] != word.charAt(idx)) return false;
        if (word.length() == idx + 1) {
            res = true;
            return true;
        }

        used[x][y] = true;
        for (int i = 0; i < dirs.length; i++) {
            int xd = x + dirs[i][0];
            int yd = y + dirs[i][1];
            if (inBox(board.length, board[0].length, xd, yd)) {
                exist(board, xd, yd, word, idx + 1, used);
            }
        }
        used[x][y] = false;

        return true;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] used = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                exist(board, i, j, word, 0, used);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(new O0012().exist(board, word));
    }

}
