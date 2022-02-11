package main.java.edu.zju.zjh.lcold;

public class T079 {
    public boolean res;
//        public int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void dfs(char[][] board, int x, int y, boolean[][] used, String words, int pos, int con) {
        int m = board.length;
        int n = board[0].length;
        if (con == words.length()) res = true;
        if (res) return;
        if (x < 0 || x >= m || y < 0 || y >= n || pos >= words.length()) return;

        char ch = board[x][y], word = words.charAt(pos);
        if (ch != word) return;

        if (used[x][y]) return;
        used[x][y] = true;

        dfs(board, x + 1, y, used, words, pos + 1, con + 1);
        dfs(board, x - 1, y, used, words, pos + 1, con + 1);
        dfs(board, x, y + 1, used, words, pos + 1, con + 1);
        dfs(board, x, y - 1, used, words, pos + 1, con + 1);
        used[x][y] = false;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        if (word.length() <= 0) return false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] used = new boolean[m][n];

                    dfs(board, i, j, used, word, 0, 0);
                    if (res) return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//
//        单词必须按照字母顺序，通过相邻的单元格内的字母构成，
//        其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
//        示例:
//        board = [
//                  ['A','B','C','E'],
//                  ['S','F','C','S'],
//                  ['A','D','E','E']
//                ]
//        给定 word = "ABCCED", 返回 true
//        给定 word = "SEE", 返回 true
//        给定 word = "ABCB", 返回 false
// 
//        提示：
//        board 和 word 中只包含大写和小写英文字母。
//        1 <= board.length <= 200
//        1 <= board[i].length <= 200
//        1 <= word.length <= 10^3

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(new T079().exist(board, "ABCCED"));
        System.out.println(new T079().exist(board, "SEE"));
        System.out.println(new T079().exist(board, "ABCB"));
    }
}
