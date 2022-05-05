package edu.zju.zjh.lc.ds.graph.unionfind;

import java.util.Arrays;
import java.util.PriorityQueue;

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
     * 执行耗时:75 ms,击败了44.62% 的Java用户
     * 内存消耗:41.9 MB,击败了52.90% 的Java用户
     */
    class UF {
        private int[] parent;
        private int count;

        public UF(int n) {
            this.count = n;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        public void union(int p, int q) {
            int x = find(p);
            int y = find(q);
            if (x == y) return;

            parent[x] = y;
            count--;
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public int count() {
            return this.count;
        }

    }

    public int minimumEffortPath1(int[][] heights) {
        int m = heights.length, n = heights[0].length, len = m * n;
        UF uf = new UF(len);
        PriorityQueue<int[]> heap = new PriorityQueue<>(
                (a, b) -> {
                    return a[2] - b[2];
                }
        );

        // init
        for (int i = 0, k = 1; i < m - 1; i++, k++) {
            for (int j = 0; j < n; j++) {
                heap.offer(new int[]{
                        i * n + j,
                        k * n + j,
                        Math.abs(heights[i][j] - heights[k][j])
                });
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0, k = 1; j < n - 1; j++, k++) {
                heap.offer(new int[]{
                        i * n + j,
                        i * n + k,
                        Math.abs(heights[i][j] - heights[i][k])
                });
            }
        }

        int a = 0, b = len - 1;
        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            int p = cur[0], q = cur[1], dis = cur[2];
            uf.union(p, q);

            if (uf.connected(a, b)) {
                return dis;
            }
        }

        return 0;
    }

}
