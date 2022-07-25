package edu.zju.zjh.topk.星湖科技.d20220715;

import java.util.*;

/**
 * @author: zjh
 * @date : 2022/7/15 16:20
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q002 {

    public static int[][] dirs = new int[][]{
            new int[]{0, 1},
            new int[]{0, -1},
            new int[]{1, 0},
            new int[]{-1, 0}
    };

    public static boolean inBox(int[][] box, int x, int y) {
        if (x < 0 || x >= box.length) return false;
        if (y < 0 || y >= box[0].length) return false;

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = sc.nextInt();
            }
        }

        boolean[][] used = new boolean[n][n];
        int[][] cnt = new int[n][n];
        Queue<int[]> q = new LinkedList<int[]>();
        int level = 0;
        boolean end = false;

        cnt[0][0] = 1;
        if (nums[0][0] == 1) q.offer(new int[]{0, 0});

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] xy = q.poll();
                int x0 = xy[0], y0 = xy[1];
                if (x0 == n - 1 && y0 == n - 1) {
                    System.out.println(level);
                    System.out.println(cnt[x0][y0]);
                    return;
                }

                if (!used[x0][y0]) {
                    for (int d = 0; d < dirs.length; d++) {
                        int x = xy[0] + dirs[d][0];
                        int y = xy[1] + dirs[d][1];

                        if (inBox(nums, x, y) && nums[x][y] == 1) {
                            cnt[x][y] += cnt[x0][y0];
                            q.offer(new int[]{x, y});
                        }
                    }
                }
                used[x0][y0] = true;
            }

            level++;
        }

        System.out.println(0);
        System.out.println(0);
    }

}
