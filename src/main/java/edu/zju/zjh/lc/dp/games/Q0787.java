package edu.zju.zjh.lc.dp.games;

import java.util.*;

/**
 * @author: zjh
 * @date : 2022/5/3 10:43
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0787 {

    /**
     * 暴力解法 超时
     */
    public int findCheapestPrice0(int n, int[][] flights, int src, int dst, int k) {
        int res = Integer.MAX_VALUE;
        Map<Integer, LinkedList<Integer>> mapToCity = new HashMap<>();
        Queue<Integer> cities = new LinkedList<Integer>() {{
            offer(src);
        }};
        Queue<Integer> costs = new LinkedList<Integer>() {{
            offer(0);
        }};

        for (int i = 0; i < flights.length; i++) {
            int city = flights[i][0];
            if (!mapToCity.containsKey(city)) {
                mapToCity.put(city, new LinkedList<>());
            }
            mapToCity.get(city).add(i);
        }

        while (k >= 0 && !cities.isEmpty()) {
            int size = cities.size();

            for (int i = 0; i < size; i++) {
                int city = cities.poll();
                int cost = costs.poll();

                for (Integer idx : mapToCity.getOrDefault(city, new LinkedList<>())) {
                    int[] flight = flights[idx];
                    if (flight[1] == dst) {
                        res = Math.min(res, cost + flight[2]);
                    }
                    cities.offer(flight[1]);
                    cities.offer(cost + flight[2]);
                }
            }
            k--;
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    /**
     * dijkstra
     * 执行耗时:5 ms,击败了67.15% 的Java用户
     * 内存消耗:41.9 MB,击败了82.55% 的Java用户
     */
    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] graph = new LinkedList[n];
        int[] disTo = new int[n];
        int[] nodeNumTo = new int[n];
        PriorityQueue<int[]> heap = new PriorityQueue<>(
                (a, b) -> {
                    return a[1] - b[1];
                }
        );

        // init
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] flight : flights) {
            graph[flight[0]].add(new int[]{flight[1], flight[2]});
        }
        Arrays.fill(disTo, Integer.MAX_VALUE);
        Arrays.fill(nodeNumTo, Integer.MAX_VALUE);
        heap.offer(new int[]{src, 0, k + 1});

        while (!heap.isEmpty()) {
            int[] now = heap.poll();
            int from = now[0];
            int dis = now[1];
            int nk = now[2];

            // if (disTo[from] < dis) continue;
            if (from == dst) {
                return dis;
            }
            if (nk == 0) continue;

            for (int[] e : graph[from]) {
                int to = e[0];
                int weight = e[1];
                int sum = dis + weight;
                int nextNodeNum = nk - 1;
                // if (nk > 0 && disTo[to] > sum) {
                if (disTo[to] > sum) {
                    disTo[to] = sum;
                    nodeNumTo[to] = nextNodeNum;
                }
                // 剪枝，如果中转次数更多，花费还更大，那必然不会是最短路径
                if (nextNodeNum < nodeNumTo[to] && sum > disTo[to]) {
                    continue;
                }
                heap.offer(new int[]{to, sum, nk - 1});
            }
        }

        return -1;
    }

    /**
     * Dynamic programming
     * 执行耗时:6 ms,击败了46.99% 的Java用户
     * 内存消耗:42.2 MB,击败了85.81% 的Java用户
     */
    private final int INF = -1;
    private int[][] memo;
    private List<int[]>[] indegree;

    public int dp(int src, int to, int k) {
        if (k < 0) return INF;
        if (src == to) return 0;
        if (memo[to][k] != 0) return memo[to][k];

        int res = Integer.MAX_VALUE;
        for (int[] e : indegree[to]) {
            int from = e[0];
            int cost = e[1];
            int subdp = dp(src, from, k - 1);
            if (subdp != INF) {
                res = Math.min(res, subdp + cost);
            }
        }

        memo[to][k] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[to][k];
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        memo = new int[n][k + 2];
        indegree = new LinkedList[n];

        for (int i = 0; i < n; i++) {
            indegree[i] = new LinkedList<>();
        }
        for (int[] flight : flights) {
            indegree[flight[1]].add(new int[]{flight[0], flight[2]});
        }

        return dp(src, dst, k + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Q0787().findCheapestPrice1(
                5,
                new int[][]{
                        new int[]{0, 1, 5},
                        new int[]{1, 2, 5},
                        new int[]{0, 3, 2},
                        new int[]{3, 1, 2},
                        new int[]{1, 4, 1},
                        new int[]{4, 2, 1}
                },
                0,
                2,
                2
        ));
        System.out.println(new Q0787().findCheapestPrice(
                5,
                new int[][]{
                        new int[]{0, 1, 5},
                        new int[]{1, 2, 5},
                        new int[]{0, 3, 2},
                        new int[]{3, 1, 2},
                        new int[]{1, 4, 1},
                        new int[]{4, 2, 1}
                },
                0,
                2,
                2
        ));
    }

}
