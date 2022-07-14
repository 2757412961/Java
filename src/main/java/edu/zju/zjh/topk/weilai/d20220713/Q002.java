package edu.zju.zjh.topk.weilai.d20220713;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: zjh
 * @date : 2022/7/13 20:47
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q002 {

    public static void main(String[] args) {
        // int x = 9, y = 6, a = 1, b = 36;
        // int x = 2, y = 3, a = 1, b = 15;
        int x = 2, y = 3, a = 1, b = 12;

        int ans = Integer.MAX_VALUE;
        int c = b / a;
        if (c * a != b) {
            System.out.println(-1);
            return;
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{c, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == 1) {
                ans = Math.min(ans, cur[1]);
            }

            if (cur[0] % x == 0) {
                q.offer(new int[]{cur[0] / x, cur[1] + 1});
            }
            if (cur[0] % y == 0) {
                q.offer(new int[]{cur[0] / y, cur[1] + 1});
            }
        }

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

}
