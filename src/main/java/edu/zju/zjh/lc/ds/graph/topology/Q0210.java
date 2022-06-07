package edu.zju.zjh.lc.ds.graph.topology;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: zjh
 * @date : 2022/6/7 14:26
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0210 {

    /**
     * 执行耗时:7 ms,击败了22.55% 的Java用户
     * 内存消耗:42 MB,击败了92.06% 的Java用户
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> res = new LinkedList<>();
        List<Integer>[] graph = new List[numCourses];
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();

        // init graph
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
        // init graph & indegree
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            graph[from].add(to);
            indegree[to]++;
        }
        // init queue
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                res.add(i);
            }
        }

        // topology sort
        while (!q.isEmpty()) {
            Integer from = q.poll();
            for (Integer to : graph[from]) {
                indegree[to]--;
                if (indegree[to] == 0) {
                    q.offer(to);
                    res.add(to);
                }
            }
        }

        if (res.size() != numCourses) {
            return new int[0];
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

}
