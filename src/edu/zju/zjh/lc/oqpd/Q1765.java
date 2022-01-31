package edu.zju.zjh.lc.oqpd;

import java.util.LinkedList;
import java.util.Queue;

public class Q1765 {

    public boolean isOutSize(int[][] isWater, int i, int j) {
        if (i < 0 || j < 0) return false;
        if (i >= isWater.length || j >= isWater[0].length) return false;
        return true;
    }

    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] res = new int[m][n];
        Queue<Integer> qi = new LinkedList<>();
        Queue<Integer> qj = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 0) {
                    res[i][j] = -1;
                } else if (isWater[i][j] == 1) {
                    qi.add(i);
                    qj.add(j);
                }
            }
        }

        while (!qi.isEmpty() && !qj.isEmpty()) {
            Integer i = qi.remove();
            Integer j = qj.remove();
            int val = res[i][j] + 1;
            if (isOutSize(isWater, i + 1, j) && res[i + 1][j] == -1) {
                res[i + 1][j] = val;
                qi.add(i + 1);
                qj.add(j);
            }
            if (isOutSize(isWater, i - 1, j) && res[i - 1][j] == -1) {
                res[i - 1][j] = val;
                qi.add(i - 1);
                qj.add(j);
            }
            if (isOutSize(isWater, i, j + 1) && res[i][j + 1] == -1) {
                res[i][j + 1] = val;
                qi.add(i);
                qj.add(j + 1);
            }
            if (isOutSize(isWater, i, j - 1) && res[i][j - 1] == -1) {
                res[i][j - 1] = val;
                qi.add(i);
                qj.add(j - 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] isWater = new int[][]{new int[]{0, 1}, new int[]{0, 0}};

        for (int[] ints : new Q1765().highestPeak(isWater)) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        int[][] isWater2 = new int[][]{new int[]{0, 0, 1}, new int[]{1, 0, 0}, new int[]{0, 0, 0}};
        for (int[] ints : new Q1765().highestPeak(isWater2)) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }

}
