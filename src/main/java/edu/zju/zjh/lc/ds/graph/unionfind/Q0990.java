package edu.zju.zjh.lc.ds.graph.unionfind;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: zjh
 * @date : 2022/5/5 16:10
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0990 {

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

    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        Queue<String> que = new LinkedList<>();

        for (int i = 0; i < equations.length; i++) {
            String equation = equations[i];
            if (equation.charAt(1) == '!') {
                que.offer(equation);
            } else {
                uf.union(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
            }
        }

        while (!que.isEmpty()) {
            String equation = que.poll();
            if (uf.connected(equation.charAt(0) - 'a', equation.charAt(3) - 'a')) {
                return false;
            }
        }

        return true;
    }

}
