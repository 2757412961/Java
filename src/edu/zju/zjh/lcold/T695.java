package edu.zju.zjh.lcold;

public class T695 {
    int count = 0;

    public int cord2num(int[] cord) {
        return cord[0] * 1000 + cord[1];
    }

    public int[] num2cord(int num) {
        int[] cord = new int[2];
        cord[0] = num / 1000;
        cord[1] = num % 1000;

        return cord;
    }

    public void dfs(int[][] grid, int num) {
        int[] cord = num2cord(num);
        int x = cord[0];
        int y = cord[1];

        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length ||
                grid[x][y] == 0) {
            return;
        }

        count++;
        grid[x][y] = 0;

        dfs(grid, cord2num(new int[]{x + 1, y}));
        dfs(grid, cord2num(new int[]{x - 1, y}));
        dfs(grid, cord2num(new int[]{x, y + 1}));
        dfs(grid, cord2num(new int[]{x, y - 1}));
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length <= 0) {
            return 0;
        }
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    count = 0;
                    dfs(grid, cord2num(new int[]{i, j}));
                    res = Math.max(res, count);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };

        T695 t695 = new T695();
        System.out.print(t695.maxAreaOfIsland(grid));
    }
}
