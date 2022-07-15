package edu.zju.zjh.topk.microsoft.d20220715;

/**
 * @author: zjh
 * @date : 2022/7/15 下午 07:22
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q003 {

    private class Point2D {
        public int x;
        public int y;
    }

    // you can also use imports, for example:
    // import java.util.*;

    // you can write to stdout for debugging purposes, e.g.
    // System.out.println("this is a debug message");

    class Solution {

        public boolean inLine(int x1, int y1, int x2, int y2) {
            return x1 * y2 == x2 * y1;
        }

        public int solution(Point2D[] A) {
            // write your code in Java SE 8
            int n = A.length;
            int res = 0;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int x1 = A[i].x - A[j].x;
                    int y1 = A[i].y - A[j].y;
                    for (int k = j + 1; k < n; k++) {
                        if (res > 100000000) return -1;
                        int x2 = A[i].x - A[k].x;
                        int y2 = A[i].y - A[k].y;

                        if (inLine(x1, y1, x2, y2)) {
                            res++;
                        }
                    }
                }
            }

            return res;
        }

    }


}
