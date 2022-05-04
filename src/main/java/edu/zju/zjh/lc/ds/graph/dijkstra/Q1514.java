package edu.zju.zjh.lc.ds.graph.dijkstra;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: zjh
 * @date : 2022/5/4 14:41
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q1514 {

    class State {
        public int idx;
        public Double prob;

        public State(int idx, Double prob) {
            this.idx = idx;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<int[]>[] graph = new List[n];
        double[] disTo = new double[n];
        PriorityQueue<State> heap = new PriorityQueue<>(
                (a, b) -> {
                    return b.prob.compareTo(a.prob);
                }
        );

        // init
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            graph[edge[0]].add(new int[]{edge[1], i});
            graph[edge[1]].add(new int[]{edge[0], i});
        }
        heap.offer(new State(start, 1.0));

        while (!heap.isEmpty()) {
            State now = heap.poll();
            int from = now.idx;
            Double prob = now.prob;

            if (prob < disTo[from]) continue;
            if (from == end) return prob;

            for (int[] e : graph[from]) {
                int to = e[0];
                double weight = succProb[e[1]];
                double multiProb = prob * weight;
                if (multiProb > disTo[to]) {
                    disTo[to] = multiProb;
                    heap.offer(new State(to, multiProb));
                }
            }
        }

        return 0;
    }

}
