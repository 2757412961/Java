package main.java.edu.zju.zjh.lcold;

import java.util.LinkedHashSet;
import java.util.Set;

public class T200 {
    int[][] used;

    public int cord2num(int[] cord) {
        return cord[0] * 1000 + cord[1];
    }

    public int[] num2cord(int num) {
        int[] cord = new int[2];
        cord[0] = num / 1000;
        cord[1] = num % 1000;

        return cord;
    }

    public int find(int[][] grid, int num) {
        int[] cord = num2cord(num);
        int x = cord[0], y = cord[1];

        if (grid[x][y] != num) {
            grid[x][y] = find(grid, grid[x][y]);
        }

        return grid[x][y];
    }

    public void union(int[][] grid, int a, int b) {
        int[] acord = num2cord(a);
        int ax = acord[0], ay = acord[1];

        grid[ax][ay] = find(grid, b);
    }

    public void dfs(int[][] grid, int num, int last) {
        int[] cord = num2cord(num);
        int x = cord[0], y = cord[1];
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length ||
                grid[x][y] == -1 || used[x][y] == 1) {
            return;
        }

        used[x][y] = 1;
        union(grid, num, last);
        dfs(grid, cord2num(new int[]{x + 1, y}), num);
        dfs(grid, cord2num(new int[]{x - 1, y}), num);
        dfs(grid, cord2num(new int[]{x, y + 1}), num);
        dfs(grid, cord2num(new int[]{x, y - 1}), num);
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] grid2 = new int[m][n];
        used = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                used[i][j] = 0;
                if (grid[i][j] == '0') {
                    grid2[i][j] = -1;
                } else {
                    grid2[i][j] = cord2num(new int[]{i, j});
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] >= 0 && used[i][j] == 0) {
                    int num = cord2num(new int[]{i, j});
                    dfs(grid2, num, num);
                }
            }
        }

        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                set.add(grid2[i][j]);
            }
        }
        set.remove(Integer.parseInt("-1"));

        return set.size();
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '0', '1', '1', '0', '0', '0',
                        '1', '1', '0', '0', '0', '1', '1', '0', '1', '1'}
        };

        T200 t200 = new T200();
        System.out.print(t200.numIslands(grid));
    }
}
