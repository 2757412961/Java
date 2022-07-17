package edu.zju.zjh.lc.math;

/**
 * @author: zjh
 * @date : 2022/7/17 19:16
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0223 {

    /**
     * 方法一：计算重叠面积
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:41 MB,击败了10.16% 的Java用户
     */
    private class S1 {

        public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
            int x = Math.min(ax2, bx2) - Math.max(ax1, bx1);
            int y = Math.min(ay2, by2) - Math.max(ay1, by1);
            int overlap = 0;
            if (x > 0 && y > 0) {
                overlap = x * y;
            }

            return (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1) - overlap;
        }

    }

}
