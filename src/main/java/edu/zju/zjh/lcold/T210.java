package main.java.edu.zju.zjh.lcold;

import java.util.LinkedList;
import java.util.Queue;

public class T210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int c = 0;
        int[] res = new int[numCourses];
        int[] inde = new int[numCourses];

        Queue<Integer> que = new LinkedList<>();

        for (int i = 0; i < prerequisites.length; i++) {
            inde[prerequisites[i][0]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (inde[i] == 0) {
                que.add(i);
            }
        }

        while (!que.isEmpty()) {
            int now = que.poll();
            res[c++] = now;

            for (int i = 0; i < prerequisites.length; i++) {
                if (now == prerequisites[i][1]) {
                    inde[prerequisites[i][0]]--;
                    if (inde[prerequisites[i][0]] == 0) {
                        que.add(prerequisites[i][0]);
                    }
                }
            }
        }


        return c < numCourses ? new int[0] : res;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{
                {1, 0},
                {0, 1}
        };

        new T210().findOrder(numCourses, prerequisites);
    }
}
