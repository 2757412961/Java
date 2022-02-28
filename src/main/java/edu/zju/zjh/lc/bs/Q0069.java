package edu.zju.zjh.lc.bs;

/**
 * @author: zjh
 * @date : 2022/2/28 13:53
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0069 {

    public int mySqrt(int x) {
        int left = 0;
        int right = x / 2 + 1;
        int res = 0;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            long mid2 = (long) mid * mid;
            if (mid2 > x) {
                right = mid - 1;
            } else if (mid2 < x) {
                res = mid;
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q0069().mySqrt(0));
        System.out.println(new Q0069().mySqrt(1));
        System.out.println(new Q0069().mySqrt(2));
        System.out.println(new Q0069().mySqrt(4));
        System.out.println(new Q0069().mySqrt(8));
        System.out.println(new Q0069().mySqrt(10));
        System.out.println(new Q0069().mySqrt(18));
        System.out.println(new Q0069().mySqrt(2147395599));
        System.out.println(new Q0069().mySqrt(2147483647));
    }

}
