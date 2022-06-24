package edu.zju.zjh.lc.math;

/**
 * @author: zjh
 * @date : 2022/6/24 下午 02:30
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0149 {

    /**
     * 方法零：向量暴力解
     * 执行耗时:35 ms,击败了13.93% 的Java用户
     * 内存消耗:38.9 MB,击败了87.06% 的Java用户
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

                    for (int k = 0; k < n; k++) {
                        if (k != i && k != j) {
                            int x2 = points[k][0] - points[i][0];
                            int y2 = points[k][1] - points[i][1];
                            if (dotProduct(x1, y1, x2, y2) == 0) {
                                count++;
                            }
                        }
                    }
                    res = Math.max(res, count);
                }
            }

            return res + 2;
        }

    }

    /**
     * 方法一：哈希表
     */

}
