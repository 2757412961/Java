package edu.zju.zjh.lcold;

import java.util.Arrays;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/8/20 上午 12:49
 * @Modified_By :
 */
public class T529 {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length;
        int n = board[0].length;
        int[] dirx = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
        int[] diry = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};

        int x = click[0];
        int y = click[1];

        if (!(0 <= x && x < m && 0 <= y && y < n)) {
            return board;
        }

        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else if (board[x][y] != 'E') {

        } else {
            int conM = 0;
            for (int i = 0; i < 8; i++) {
                int bx = dirx[i] + x;
                int by = diry[i] + y;
                if (0 <= bx && bx < m && 0 <= by && by < n && board[bx][by] == 'M') {
                    conM++;
                }
            }

            if (conM != 0) {
                board[x][y] = (char) ('0' + conM);
            } else {
                board[x][y] = 'B';
                for (int i = 0; i < 8; i++) {
                    int bx = dirx[i] + x;
                    int by = diry[i] + y;
                    updateBoard(board, new int[]{bx, by});

                }
            }
        }

        return board;
    }

    public static void main(String[] args) {
//        char[][] board = new char[][]{
//                {'E', 'E', 'E', 'E', 'E'},
//                {'E', 'E', 'M', 'E', 'E'},
//                {'E', 'E', 'E', 'E', 'E'},
//                {'E', 'E', 'E', 'E', 'E'}
//        };
//        int[] click = new int[]{3, 0};

        char[][] board = new char[][]{
                {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'M'},
                {'E', 'E', 'M', 'E', 'E', 'E', 'E', 'E'},
                {'M', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'M', 'E', 'E', 'E', 'E'},
        };
        int[] click = new int[]{0, 0};

        char[][] res = new T529().updateBoard(board, click);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
