package edu.zju.zjh.lc.fs.bfs;

/**
 * @author: zjh
 * @date : 2022/6/7 16:00
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0695 {

    /**
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:41.2 MB,击败了90.44% 的Java用户
     */
    public int bfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length) return 0;
        if (y < 0 || y >= grid[0].length) return 0;
        if (grid[x][y] == 0) return 0;
        grid[x][y] = 0;

        return 1 +
                bfs(grid, x + 1, y) +
                bfs(grid, x - 1, y) +
                bfs(grid, x, y + 1) +
                bfs(grid, x, y - 1);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                res = Math.max(res, bfs(grid, i, j));
            }
        }

        return res;
    }

}
