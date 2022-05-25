package edu.zju.zjh.lc.binarysearch;

/**
 * @author: zjh
 * @date : 2022/5/25 16:29
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0367 {

    /**
     * 方法三：二分查找 时间复杂度：O(logn)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.5 MB,击败了5.01% 的Java用户
     */
    public boolean isPerfectSquare(int num) {
        int l = 1, r = num / 2 + 1, m = 0;
        long m2 = 0;

        while (l <= r) {
            m = l + (r - l) / 2;
            m2 = (long) m * m;
            if (m2 == num) {
                return true;
            } else if (m2 > num) {
                r = m - 1;
            } else if (m2 < num) {
                l = m + 1;
            }
        }

        return false;
    }

    /**
     * 方法四：牛顿迭代法 时间复杂度：O(logn)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.1 MB,击败了67.13% 的Java用户
     */
    public boolean isPerfectSquareMath(int num) {
        int n = 0;
        double x = num, x1 = num + 1;

        while (x1 - x >= 1e-6) {
            x1 = x;
            x = (x + num / x) / 2;
        }

        n = ((int) x);

        return n * n == num;
    }

}
