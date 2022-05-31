package edu.zju.zjh.lc.fs.bfs;

/**
 * @author: zjh
 * @date : 2022/5/31 20:55
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0200 {

    /**
     * 执行耗时:3 ms,击败了61.72% 的Java用户
     * 内存消耗:49.6 MB,击败了61.92% 的Java用户
     */
    public void fillLand(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length) return;
        if (j < 0 || j >= grid[0].length) return;
        if (grid[i][j] != '1') return;

        grid[i][j] = '0';
        fillLand(grid, i + 1, j);
        fillLand(grid, i - 1, j);
        fillLand(grid, i, j + 1);
        fillLand(grid, i, j - 1);
    }

    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length, n = grid[0].length;


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    fillLand(grid, i, j);
                }
            }
        }

        return res;
    }

}
