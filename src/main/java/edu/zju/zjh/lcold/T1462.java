package main.java.edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/7/19 下午 09:27
 * @Modified_By :
 */
public class T1462 {

    public boolean check(int n, ArrayList<Integer>[] pres, int sta, int end) {
        int used[] = new int[n];
        Queue<Integer> que = new LinkedList<>();

        que.add(sta);
        used[sta] = 1;

        while (!que.isEmpty()) {
            int now = que.poll();

            for (int i = 0; i < pres[now].size(); i++) {
                int next = pres[now].get(i);
                if (used[next] == 0) {
                    if (next == end) return true;
                    used[next] = 1;
                    que.add(next);
                }
            }
        }


        return false;
    }

    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        ArrayList<Integer>[] pres = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            pres[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            pres[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        for (int i = 0; i < queries.length; i++) {
            res.add(check(n, pres, queries[i][0], queries[i][1]));
        }

        return res;
    }

    public static void main(String[] args) {
//        int n = 3;
//        int[][] prerequisites = new int[][]{
//                {1, 2},
//                {1, 0},
//                {2, 0}
//        };
//        int[][] queries = new int[][]{
//                {1, 0},
//                {1, 2}
//        };

        int n = 4;
        int[][] prerequisites = new int[][]{
                {2, 3},
                {2, 1},
                {0, 3},
                {0, 1},
        };
        int[][] queries = new int[][]{
                {0, 1},
                {0, 3},
                {2, 3},
                {3, 0},
                {2, 0},
                {0, 2},
        };

        new T1462().checkIfPrerequisite(n, prerequisites, queries);
    }
}
