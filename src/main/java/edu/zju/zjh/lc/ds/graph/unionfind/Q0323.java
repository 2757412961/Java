package edu.zju.zjh.lc.ds.graph.unionfind;

/**
 * @author: zjh
 * @date : 2022/5/5 15:45
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0323 {

    class UnionFind {

        private int[] parent;
        private int count;

        public UnionFind(int n) {
            this.count = n;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int p = find(x);
            int q = find(y);

            if (p == q) return;
            parent[p] = q;
            count--;
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public int count() {
            return this.count;
        }

    }

    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < edges.length; i++) {
            uf.union(edges[i][0], edges[i][1]);
        }

        return uf.count();
    }

}
