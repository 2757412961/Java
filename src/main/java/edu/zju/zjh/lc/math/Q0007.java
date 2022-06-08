package edu.zju.zjh.lc.math;

/**
 * @author: zjh
 * @date : 2022/6/8 14:29
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0007 {

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.5 MB,击败了83.11% 的Java用户
     */
    public int reverse(int x) {
        int sign = 1;
        long num = x, res = 0;
        if (num < 0) {
            sign = -1;
            num = -num;
        }

        while (num > 0) {
            res = res * 10 + num % 10;
            num /= 10;
        }

        res *= sign;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;

        return ((int) res);
    }

}
