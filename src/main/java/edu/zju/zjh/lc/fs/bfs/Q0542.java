package edu.zju.zjh.lc.fs.bfs;

import java.util.LinkedList;

/**
 * @author: zjh
 * @date : 2022/6/8 20:54
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0542 {

    /**
     * 执行耗时:25 ms,击败了6.65% 的Java用户
     * 内存消耗:49.5 MB,击败了5.08% 的Java用户
     */
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] res = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        LinkedList<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int depth = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] xy = q.poll();
                int x = xy[0], y = xy[1];
                if (x < 0 || x >= m) continue;
                if (y < 0 || y >= n) continue;
                if (!vis[x][y]) {
                    vis[x][y] = true;
                    res[x][y] = depth;
                    q.offer(new int[]{x + 1, y});
                    q.offer(new int[]{x - 1, y});
                    q.offer(new int[]{x, y + 1});
                    q.offer(new int[]{x, y - 1});
                }
            }
            depth++;
        }

        return res;
    }

}
