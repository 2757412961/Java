package main.java.edu.zju.zjh.lcold;

public class T130 {
    int m, n;

    public void dfs(char[][] board, int x, int y, char filled, char flag) {
        if (x < 0 || x >= m || y < 0 || y >= n ||
                board[x][y] == 'X' || board[x][y] == flag) {
            return;
        }

        board[x][y] = filled;
        dfs(board, x + 1, y, filled, flag);
        dfs(board, x - 1, y, filled, flag);
        dfs(board, x, y + 1, filled, flag);
        dfs(board, x, y - 1, filled, flag);
    }

    public void solve_20200811(char[][] board) {
        if (board.length == 0) {
            return;
        }
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' &&
                        (i == 0 || i == m - 1 || j == 0 || j == n - 1)) {
                    dfs(board, i, j, '.', '.');
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    dfs(board, i, j, 'X', '.');
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs_2(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }

        if (board[x][y] == '.') {
            board[x][y] = 'O';
            dfs_2(board, x + 1, y);
            dfs_2(board, x - 1, y);
            dfs_2(board, x, y + 1);
            dfs_2(board, x, y - 1);
        }
    }

    public void solve(char[][] board) {
        if (board.length <= 0) return;
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = '.';
                }
            }
        }

        for (int i = 0; i < m; i++) {
            dfs_2(board, i, 0);
            dfs_2(board, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs_2(board, 0, j);
            dfs_2(board, m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    board[i][j] = 'X';
                }
            }
        }
    }


    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        T130 t130 = new T130();
        t130.solve(board);
        t130.solve_20200811(board);
    }
}
