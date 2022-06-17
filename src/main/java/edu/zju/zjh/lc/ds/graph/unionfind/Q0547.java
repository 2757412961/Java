package edu.zju.zjh.lc.ds.graph.unionfind;

/**
 * @author: zjh
 * @date : 2022/6/17 10:26
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0547 {

    private class UnionFind {

        private int size;
        private int[] nums;

        public UnionFind(int n) {
            this.size = n;
            this.nums = new int[n];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = i;
            }
        }

        public int find(int x) {
            if (x == nums[x]) {
                return x;
            }

            return nums[x] = find(nums[x]);
        }

        public void union(int x, int y) {
            final int a = find(x);
            final int b = find(y);
            if (a != b) {
                nums[a] = b;
                size--;
            }
        }

        public int size() {
            return this.size;
        }

    }

    /**
     * 执行耗时:1 ms,击败了85.78% 的Java用户
     * 内存消耗:42.3 MB,击败了38.95% 的Java用户
     */
    public int findCircleNum(int[][] isConnected) {
        int res = 0;
        UnionFind uf = new UnionFind(isConnected.length);

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i + 1; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }

        return uf.size();
    }

}
