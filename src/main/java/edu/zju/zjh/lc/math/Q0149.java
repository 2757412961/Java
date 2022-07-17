package edu.zju.zjh.lc.math;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zjh
 * @date : 2022/6/24 下午 02:30
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0149 {

    /**
     * 方法零：向量暴力解
     * 执行耗时:9 ms,击败了81.64% 的Java用户
     * 内存消耗:38.9 MB,击败了87.10% 的Java用户
     */
    private class S1 {

        public int dotProduct(int x1, int y1, int x2, int y2) {
            return x1 * y2 - x2 * y1;
        }

        public int maxPoints(int[][] points) {
            if (points.length < 2) return points.length;
            int res = 0;
            int n = points.length;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int count = 0;
                    int x1 = points[j][0] - points[i][0];
                    int y1 = points[j][1] - points[i][1];

                    //for (int k = 0; k < n; k++) {
                    //    if (k != i && k != j) {
                    //        int x2 = points[k][0] - points[i][0];
                    //        int y2 = points[k][1] - points[i][1];
                    //        if (dotProduct(x1, y1, x2, y2) == 0) {
                    //            count++;
                    //        }
                    //    }
                    //}
                    // 当我们枚举到点 i 时，我们只需要考虑编号大于 i 的点到点 i 的斜率，
                    // 因为如果直线同时经过编号小于点 i 的点 j，那么当我们枚举到 j 时就已经考虑过该直线了；
                    for (int k = j + 1; k < n; k++) {
                        int x2 = points[k][0] - points[i][0];
                        int y2 = points[k][1] - points[i][1];
                        if (dotProduct(x1, y1, x2, y2) == 0) {
                            count++;
                        }
                    }
                    res = Math.max(res, count);
                }
            }

            return res + 2;
        }

    }

    /**
     * 方法一：哈希表（四个优化）
     * https://leetcode.cn/problems/max-points-on-a-line/solution/zhi-xian-shang-zui-duo-de-dian-shu-by-le-tq8f/
     * https://leetcode.cn/problems/max-points-on-a-line/solution/gong-shui-san-xie-liang-chong-mei-ju-zhi-u44s/
     * <p>
     * gcd
     * https://leetcode.cn/problems/greatest-common-divisor-of-strings/solution/zi-fu-chuan-de-zui-da-gong-yin-zi-by-leetcode-solu/
     * <p>
     * 执行耗时:30 ms,击败了31.74% 的Java用户
     * 内存消耗:42 MB,击败了11.52% 的Java用户
     */
    class S2 {

        /**
         * 特殊情况考虑
         * a = 0, b = 0
         * a = 3, b = 0
         * a = 0, b = 3
         * a = 24, b = -9
         */
        public int gcd(int a, int b) {
            if (b == 0) return a;
            return gcd(b, a % b);
        }

        public int maxPoints(int[][] points) {
            int res = 1;
            int n = points.length;

            for (int i = 0; i < n; i++) {
                Map<String, Integer> map = new HashMap<>();
                for (int j = i + 1; j < n; j++) {
                    int x = points[j][0] - points[i][0];
                    int y = points[j][1] - points[i][1];
                    int k = gcd(x, y);
                    String key = (x / k) + "_" + (y / k);
                    int val = map.getOrDefault(key, 1) + 1;

                    map.put(key, val);
                    res = Math.max(res, val);
                }
            }

            return res;
        }

    }

}
