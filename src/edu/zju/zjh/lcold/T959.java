package edu.zju.zjh.lcold;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/8/15 上午 10:49
 * @Modified_By :
 */
public class T959 {
    public void dfs(int x, int y, char d, int[][][] used, int[][] grids) {
        int n = used.length;
        if (x < 0 || y < 0 || x >= n || y >= n) return;

        int now = grids[x][y];
        int z = 0;
        if (now == 1 && (d == 'a' || d == 'w')) {
            z = 0;
        } else if (now == 1 && (d == 's' || d == 'd')) {
            z = 1;
        } else if (now == -1 && (d == 'a' || d == 's')) {
            z = 0;
        } else if (now == -1 && (d == 'w' || d == 'd')) {
            z = 1;
        }

        if (used[x][y][z] == 1) return;
        used[x][y][z] = 1;

        if (now == 0) {
            used[x][y][0] = 1;
            used[x][y][1] = 1;

            dfs(x - 1, y, 's', used, grids);
            dfs(x + 1, y, 'w', used, grids);
            dfs(x, y - 1, 'd', used, grids);
            dfs(x, y + 1, 'a', used, grids);
        } else if (now == 1 && z == 0) {
            dfs(x - 1, y, 's', used, grids);
            dfs(x, y - 1, 'd', used, grids);
        } else if (now == 1 && z == 1) {
            dfs(x + 1, y, 'w', used, grids);
            dfs(x, y + 1, 'a', used, grids);
        } else if (now == -1 && z == 0) {
            dfs(x + 1, y, 'w', used, grids);
            dfs(x, y - 1, 'd', used, grids);
        } else if (now == -1 && z == 1) {
            dfs(x - 1, y, 's', used, grids);
            dfs(x, y + 1, 'a', used, grids);
        }
    }

    public int regionsBySlashes(String[] grid) {
        if (grid.length <= 0) return 0;
        int n = grid.length;
        int res = 0;
        int[][][] used = new int[n][n][2];

        int[][] grids = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j >= grid[i].length() || grid[i].charAt(j) == ' ') {
                    grids[i][j] = 0;
                } else if (grid[i].charAt(j) == '/') {
                    grids[i][j] = 1;
                } else if (grid[i].charAt(j) == '\\') {
                    grids[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    if (used[i][j][k] == 0) {
                        dfs(i, j, k == 0 ? 'a' : 'd', used, grids);
                        res++;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。这些字符会将方块划分为一些共边的区域。
//       （请注意，反斜杠字符是转义的，因此 \ 用 "\\" 表示。）。

//        String[] grid = new String[]{
//                "\\/",
//                "/\\"
//        };
        String[] grid = new String[]{
                "//",
                "/ "
        };

        System.out.println(new T959().regionsBySlashes(grid));
    }
}
