package edu.zju.zjh.lc.ds.graph.dijkstra;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author: zjh
 * @date : 2022/5/4 14:43
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q1631 {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean inbox(int[][] box, int x, int y) {
        if (x < 0 || x >= box.length) return false;
        if (y < 0 || y >= box[0].length) return false;

        return true;
    }

    /**
     * dijkstra
     * 执行耗时:42 ms,击败了94.79% 的Java用户
     * 内存消耗:42.3 MB,击败了21.64% 的Java用户
     */
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] disTo = new int[m][n];
        PriorityQueue<int[]> heap = new PriorityQueue<>(
                (a, b) -> {
                    return a[2] - b[2];
                }
        );

        // init
        for (int i = 0; i < m; i++) {
            Arrays.fill(disTo[i], Integer.MAX_VALUE);
        }
        disTo[0][0] = 0;
        heap.offer(new int[]{0, 0, 0});

        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            int i = cur[0];
            int j = cur[1];
            int curDis = cur[2];

            if (i == m - 1 && j == n - 1) return curDis;
            if (curDis > disTo[i][j]) continue;

            for (int d = 0; d < dirs.length; d++) {
                int x = i + dirs[d][0];
                int y = j + dirs[d][1];
                if (inbox(heights, x, y)) {
                    int diff = Math.abs(heights[i][j] - heights[x][y]);
                    int dis = Math.max(curDis, diff);
                    if (disTo[x][y] > dis) {
                        disTo[x][y] = dis;
                        heap.offer(new int[]{x, y, dis});
                    }
                }
            }
        }

        return 0;
    }

    /**
     * Union find
     */
    public int minimumEffortPath1(int[][] heights) {

        return -1;
    }

}
