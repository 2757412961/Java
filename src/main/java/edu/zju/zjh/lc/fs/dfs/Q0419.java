package edu.zju.zjh.lc.fs.dfs;

/**
 * @author: zjh
 * @date : 2022/6/23 下午 04:32
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0419 {

    /**
     * 方法一：遍历扫描 代码直接摘录官方答案
     * 麻了，看了许久的题目，下面是题目本意：
     * https://itcn.blog/p/503650404.html
     */
    public int countBattleships(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        int ans = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (board[i][j] == 'X') {
                    board[i][j] = '.';
                    for (int k = j + 1; k < col && board[i][k] == 'X'; ++k) {
                        board[i][k] = '.';
                    }
                    for (int k = i + 1; k < row && board[k][j] == 'X'; ++k) {
                        board[k][j] = '.';
                    }
                    ans++;
                }
            }
        }
        return ans;
    }

}
