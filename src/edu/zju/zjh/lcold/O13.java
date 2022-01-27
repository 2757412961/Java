package edu.zju.zjh.lcold;

public class O13 {
    int res = 0;
    int[][] vals;
    boolean[][] used;

    public int calDigitsSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }

        return sum;
    }

    public void dfs(int i, int j, int k) {
        if (i < 0 || i >= vals.length ||
            j < 0 || j >= vals[0].length) {
            return;
        }

        if (!used[i][j] && vals[i][j] <= k) {
            res++;
            used[i][j] = true;
            dfs(i, j-1, k);
            dfs(i, j+1, k);
            dfs(i-1, j, k);
            dfs(i+1, j, k);
        }
    }


    public int movingCount(int m, int n, int k) {
        vals = new int[m][n];
        used = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                vals[i][j] = calDigitsSum(i) + calDigitsSum(j);
                used[i][j] = false;
            }
        }

        dfs(0, 0, k);

        return res;
    }

    public static void main(String[] args) {
        O13 o13 = new O13();
        System.out.println(o13.movingCount(2, 3, 1));
    }
}
