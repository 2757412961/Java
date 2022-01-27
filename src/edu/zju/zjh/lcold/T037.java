package edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.Arrays;

public class T037 {
    private final int n = 9;
    private int blanks = 0;
    private boolean[][] rows = new boolean[9][9];
    private boolean[][] cols = new boolean[9][9];
    private boolean[][][] bolcks = new boolean[3][3][9];
    private ArrayList<int[]> dots = new ArrayList<>();

    public void huishu(char[][] board, int pos) {
        if (pos >= dots.size()) return;
        int[] ij = dots.get(pos);
        int i = ij[0], j = ij[1];

        for (int num = 0; num < rows.length; num++) {
            if (!rows[i][num] && !cols[j][num] && !bolcks[i / 3][j / 3][num]) {
                rows[i][num] = true;
                cols[j][num] = true;
                bolcks[i / 3][j / 3][num] = true;
                blanks -= 1;
                board[i][j] = (char) ('0' + num + 1);

//                for (int z = 0; z < board.length; z++) {
//                    System.out.println(Arrays.toString(board[z]));
//                }
//                System.out.println();

                huishu(board, pos + 1);
                if (blanks == 0) return;

                rows[i][num] = false;
                cols[j][num] = false;
                bolcks[i / 3][j / 3][num] = false;
                blanks += 1;
                board[i][j] = '.';
            }
        }
    }

    public void solveSudoku(char[][] board) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0' - 1;
                    rows[i][num] = true;
                    cols[j][num] = true;
                    bolcks[i / 3][j / 3][num] = true;
                } else {
                    blanks++;
                    dots.add(new int[]{i, j});
                }
            }
        }

        huishu(board, 0);
    }

    public static void main(String[] args) {
//        编写一个程序，通过已填充的空格来解决数独问题。
//
//        一个数独的解法需遵循如下规则：
//            数字 1-9 在每一行只能出现一次。
//            数字 1-9 在每一列只能出现一次。
//            数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
//            空白格用 '.' 表示。

        String[][] tempBoard = new String[][]{
                {"5", "3", ".", ".", "7", ".", ".", ".", "."},
                {"6", ".", ".", "1", "9", "5", ".", ".", "."},
                {".", "9", "8", ".", ".", ".", ".", "6", "."},
                {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
                {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
                {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
                {".", "6", ".", ".", ".", ".", "2", "8", "."},
                {".", ".", ".", "4", "1", "9", ".", ".", "5"},
                {".", ".", ".", ".", "8", ".", ".", "7", "9"}
        };

        char[][] board = new char[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = tempBoard[i][j].charAt(0);
            }
        }

        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println();
        new T037().solveSudoku(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
}
