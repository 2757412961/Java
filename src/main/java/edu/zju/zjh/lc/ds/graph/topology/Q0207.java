package edu.zju.zjh.lc.ds.graph.topology;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: zjh
 * @date : 2022/6/7 14:12
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0207 {

    /**
     * 拓扑排序
     * 执行耗时:4 ms,击败了61.98% 的Java用户
     * 内存消耗:41.4 MB,击败了76.14% 的Java用户
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
            }
        }

        // topology sort
        while (!q.isEmpty()) {
            Integer from = q.poll();
            for (Integer to : graph[from]) {
                indegree[to]--;
                if (indegree[to] == 0) {
                    q.offer(to);
                }
            }
        }

        // check
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] != 0) {
                return false;
            }
        }

        return true;
    }

}
