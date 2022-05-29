package edu.zju.zjh.lc.math;

/**
 * @author: zjh
 * @date : 2022/5/29 16:21
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0050 {

    /**
     * 方法一：快速幂 + 递归 时间复杂度：O(logn)
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.7 MB,击败了30.00% 的Java用户
     */
    public double myPow(double x, long n) {
        if (n == 0) return 1;

        double v = myPow(x, n / 2);
        if (n % 2 == 0) {
            return v * v;
        } else {
            return v * v * x;
        }
    }

    public double myPow(double x, int n) {
        long ln = n;
        if (ln == 0) {
            return 1;
        } else if (ln > 0) {
            return myPow(x, ln);
        } else if (ln < 0) {
            return 1 / myPow(x, -ln);
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(new Q0050().myPow(1, 123123));
        System.out.println(new Q0050().myPow(2, 3));
        System.out.println(new Q0050().myPow(2, -3));
        System.out.println(new Q0050().myPow(2.5, 3));
    }

}
