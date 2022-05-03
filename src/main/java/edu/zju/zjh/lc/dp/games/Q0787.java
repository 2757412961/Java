package edu.zju.zjh.lc.dp.games;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author: zjh
 * @date : 2022/5/3 10:43
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0787 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
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

}
