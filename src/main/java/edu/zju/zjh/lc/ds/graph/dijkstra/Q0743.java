package edu.zju.zjh.lc.ds.graph.dijkstra;

import java.util.*;

/**
 * @author: zjh
 * @date : 2022/5/4 10:23
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0743 {

    public int networkDelayTime(int[][] times, int n, int k) {
        int res = Integer.MIN_VALUE;
        int[] minDis = new int[n + 1];
        boolean[] used = new boolean[n + 1];
        List<int[]>[] graph = new LinkedList[n + 1];
        PriorityQueue<int[]> heap = new PriorityQueue<>(
                (a, b) -> {
                    return a[1] - b[1];
                }
        );

        // init
        Arrays.fill(minDis, Integer.MAX_VALUE);
        minDis[k] = 0;
        heap.offer(new int[]{k, 0});
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < times.length; i++) {
            int[] time = times[i];
            graph[time[0]].add(new int[]{time[1], time[2]});
        }

        while (!heap.isEmpty()) {
            int[] now = heap.poll();
            int startId = now[0];
            int startDis = now[1];
            if (used[startId]) continue;
            used[startId] = true;

            for (int[] e : graph[startId]) {
                int endId = e[0];
                int weight = e[1];
                if (!used[endId]) {
                    int dis = startDis + weight;
                    if (dis < minDis[endId]) {
                        minDis[endId] = dis;
                        heap.offer(new int[]{endId, dis});
                    }
                }
            }
        }

        for (int i = 1; i < minDis.length; i++) {
            res = Math.max(res, minDis[i]);
        }
        if (res == Integer.MAX_VALUE) return -1;

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q0743().networkDelayTime(
                new int[][]{
                        new int[]{2, 1, 1},
                        new int[]{2, 3, 1},
                        new int[]{3, 4, 1}
                },
                4,
                2
        ));
    }

}
