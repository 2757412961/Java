package edu.zju.zjh.lc.math;

/**
 * @author: zjh
 * @date : 2022/5/29 16:31
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0069 {

    /**
     * 执行耗时:1 ms,击败了94.66% 的Java用户
     * 内存消耗:38.9 MB,击败了20.16% 的Java用户
     */
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
