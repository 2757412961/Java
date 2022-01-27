package edu.zju.zjh.lcold;

import java.util.Stack;

public class T947 {
    public int removeStones(int[][] stones) {
        int res = 0;
        int n = stones.length;
        int[][] paths = new int[n][n];
        int[] used = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    paths[i][j] = 1;
                    paths[j][i] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (used[i] == 1) {
                continue;
            }

            stack.clear();
            stack.push(i);

            while (!stack.isEmpty()) {
                int now = stack.peek();
                used[now] = 1;

                int j = 0;
                for (; j < n; j++) {
                    if (paths[now][j] != 0) {
                        if (used[j] == 1) {
                            continue;
                        }

                        stack.push(j);
                        break;
                    }
                }

                if (j == n) {
                    stack.pop();
                }
            }

            res++;
        }

        return n - res;
    }

    public static void main(String[] args) {
        int[][] stones = new int[][]{
                {0, 0},
                {0, 1},
                {1, 0},
                {1, 2},
                {2, 1},
                {2, 2}
        };

        System.out.println(new T947().removeStones(stones));
    }
}
