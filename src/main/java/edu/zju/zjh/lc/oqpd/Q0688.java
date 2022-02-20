package edu.zju.zjh.lc.oqpd;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author: zjh
 * @date : 2022/2/17 16:46
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0688 {

    private int[][] dirs = new int[][]{
            new int[]{1, 2},
            new int[]{2, 1},
            new int[]{1, -2},
            new int[]{2, -1},
            new int[]{-1, -2},
            new int[]{-2, -1},
            new int[]{-1, 2},
            new int[]{-2, 1}
    };

    public boolean isInBox(int n, int row, int column) {
        if (row < 0 || row >= n) {
            return false;
        }
        if (column < 0 || column >= n) {
            return false;
        }
        return true;
    }

    public double knightProbabilityOutMemory(int n, int k, int row, int column) {
        double res = 1;
        Queue<int[]> pos = new ArrayDeque<>();
        if (isInBox(n, row, column)) {
            pos.add(new int[]{row, column});
        }

        for (int i = 0; i < k; i++) {
            int size = pos.size();
            for (int j = 0; j < size; j++) {
                int[] xy = pos.remove();
                for (int d = 0; d < dirs.length; d++) {
                    if (isInBox(n, xy[0] + dirs[d][0], xy[1] + dirs[d][1])) {
                        pos.add(new int[]{xy[0] + dirs[d][0], xy[1] + dirs[d][1]});
                    }
                }
            }
            res /= dirs.length;
        }

        return res * pos.size();
    }

    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n][n][k + 1];

        for (int step = 0; step <= k; step++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (step == 0) {
                        dp[i][j][step] = 1;
                    } else {
                        for (int d = 0; d < dirs.length; d++) {
                            int x = i + dirs[d][0];
                            int y = j + dirs[d][1];
                            if (isInBox(n, x, y)) {
                                dp[i][j][step] += dp[x][y][step - 1]/8;
                            }
                        }
                    }
                }
            }
        }

        return dp[row][column][k];
    }


    public static void main(String[] args) {
//        示例 1：
//        输入: n = 3, k = 2, row = 0, column = 0
//        输出: 0.0625
//        解释: 有两步(到(1,2)，(2,1))可以让骑士留在棋盘上。
//        在每一个位置上，也有两种移动可以让骑士留在棋盘上。
//        骑士留在棋盘上的总概率是0 .0625。
        System.out.println(new Q0688().knightProbability(3, 2, 0, 0));

//        示例 2：
//        输入: n = 1, k = 0, row = 0, column = 0
//        输出: 1.00000
        System.out.println(new Q0688().knightProbability(1, 0, 0, 0));

        System.out.println(new Q0688().knightProbability(8, 30, 6, 4));

    }

}
