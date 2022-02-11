package main.java.edu.zju.zjh.lcold;

import java.util.HashSet;
import java.util.Set;

public class T785 {
    int[][] edges;
    int con = 0;

    public boolean departSet(int idx, Set<Integer> setA, Set<Integer> setB) {
        if (idx >= con) return true;

        int a = edges[idx][0];
        int b = edges[idx][1];

        Boolean flag1 = false;
        Boolean flag2 = false;
        if (!setA.contains(a) && !setB.contains(b)) {
            Set<Integer> seta = new HashSet<>(setA);
            seta.add(b);
            Set<Integer> setb = new HashSet<>(setB);
            setb.add(a);

            flag1 = departSet(idx + 1, seta, setb);
        }
        if (!setA.contains(b) && !setB.contains(a)) {
            Set<Integer> seta = new HashSet<>(setA);
            seta.add(a);
            Set<Integer> setb = new HashSet<>(setB);
            setb.add(b);

            flag2 = departSet(idx + 1, seta, setb);
        }

        return flag1 || flag2;
    }

    public boolean isBipartite_violence(int[][] graph) {
        int n = graph.length;
        edges = new int[n * n / 2][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (i < graph[i][j]) {
                    edges[con][0] = i;
                    edges[con][1] = graph[i][j];
                    con++;
                }
            }
        }

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        return departSet(0, setA, setB);
    }

    Boolean res = true;
    int[] used;
    int[] color;

    public void dfs(int[][] graph, int now, int col) {
        if (used[now] == 1) return;
        used[now] = 1;
        color[now] = col;

        for (int i = 0; i < graph[now].length; i++) {
            int next = graph[now][i];
            if (color[next] != 0 && color[next] != -col) {
                res = false;
                break;
            }

            dfs(graph, next, -col);
        }
    }

    public Boolean isBipartite(int[][] graph) {
        int n = graph.length;
        used = new int[n];
        color = new int[n];

        int sta = 0;
        for (int i = 0; i < n; i++) {
            if (used[i] == 0) {
                dfs(graph, i, 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        int[][] graph = new int[][]{
//                {1, 3},
//                {0, 2},
//                {1, 3},
//                {0, 2},
//        };

        int[][] graph = new int[][]{
                {1, 2, 3},
                {0, 2},
                {0, 1, 3},
                {0, 2},
        };

        System.out.println(new T785().isBipartite(graph));
        System.out.println(new T785().isBipartite_violence(graph));
    }
}
