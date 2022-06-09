package edu.zju.zjh.lc.math;

/**
 * @author: zjh
 * @date : 2022/3/12 15:51
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0016 {

    public double myPowLong(double x, long n) {
        if (n == 0) return 1;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        if (n % 2 == 0) {
            return myPowLong(x * x, n >> 1);
        } else {
            return myPowLong(x * x, n >> 1) * x;
        }
    }

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        long N = n;

        return myPowLong(x, N);
    }

}
