package edu.zju.zjh.lc.math;

/**
 * @author: zjh
 * @date : 2022/7/22 22:24
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q1232 {

    /**
     * 辗转相除
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.3 MB,击败了12.87% 的Java用户
     */
    private class S1 {

        public int gcd(int a, int b) {
            if (a == 0) return b;
            if (b == 0) return a;
            return gcd(b, a % b);
        }

        public boolean checkStraightLine(int[][] coordinates) {
            int a = coordinates[1][0] - coordinates[0][0], b = coordinates[1][1] - coordinates[0][1], c = gcd(a, b);
            a /= c;
            b /= c;

            for (int i = 2; i < coordinates.length; i++) {
                int x = coordinates[i][0] - coordinates[0][0];
                int y = coordinates[i][1] - coordinates[0][1];
                c = gcd(x, y);
                x /= c;
                y /= c;
                if (a != x || b != y) return false;
            }

            return true;
        }

    }

}
