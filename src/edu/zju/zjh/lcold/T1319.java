package edu.zju.zjh.lcold;


public class T1319 {
    public void init(int[] groupSet, int n) {
        for (int i = 0; i < n; i++) {
            groupSet[i] = i;
        }
    }

    public int find(int[] groupSet, int x) {
        if (groupSet[x] == x) {
            return x;
        }
        groupSet[x] = find(groupSet, groupSet[x]);

        return groupSet[x];
    }

    public void union(int[] groupSet, int x, int y) {
        groupSet[find(groupSet, y)] = find(groupSet, x);
    }

    public int makeConnected(int n, int[][] connections) {
        if (n-1 > connections.length){
            return -1;
        }

        int res = n - 1;
        int[] groupSet = new int[n];

        init(groupSet, n);

        for (int i = 0; i < connections.length; i++) {
            int a = connections[i][0];
            int b = connections[i][1];
            if (find(groupSet, a) != find(groupSet, b)) {
                union(groupSet, a, b);
                res -= 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] connections = {{0, 1}, {0, 2}, {0, 3}, {1, 2}};

        T1319 t1319 = new T1319();
        System.out.println(t1319.makeConnected(6, connections));
    }
}
