package edu.zju.zjh.lc.math;

/**
 * @author: zjh
 * @date : 2022/5/29 16:31
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0069 {

    /**
     * 二分查找
     * 执行耗时:1 ms,击败了94.66% 的Java用户
     * 内存消耗:38.9 MB,击败了20.16% 的Java用户
     */
    private class S1 {

        public int mySqrt(int x) {
            int l = 1, r = x / 2 + 1, m = -1;
            long m2 = -1;

            while (l < r) {
                m = l + (r - l) / 2;
                m2 = ((long) m) * m;
                if (m2 == x) {
                    return m;
                } else if (m2 > x) {
                    r = m;
                } else if (m2 < x) {
                    l = m + 1;
                }
            }

            return ((long) l) * l > x ? l - 1 : l;
        }

    }

    /**
     * 二刷
     * 执行耗时:1 ms,击败了94.55% 的Java用户
     * 内存消耗:39 MB,击败了7.76% 的Java用户
     */
    private class S2 {

        public int mySqrt(int x) {
            int l = 0, r = x / 2 + 1, m = -1;
            long m2 = -1;

            // 定义的查找区间是左闭右开，取不到右边界；当 left == right 时，循环退出，由于 right 取不到，
            // 而且平方根有点向下取整的意味，所以取 right - 1；
            while (l < r) {
                m = l + (r - l) / 2;
                m2 = 1L * m * m;

                if (m2 == x) {
                    r = m;
                } else if (m2 > x) {
                    r = m;
                } else if (m < x) {
                    l = m + 1;
                }
            }

            return l * l == x ? l : l - 1;
        }

    }

}
