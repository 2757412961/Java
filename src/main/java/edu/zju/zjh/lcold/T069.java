package main.java.edu.zju.zjh.lcold;

public class T069 {
    public int mySqrt1(int x) {

        return (int) Math.sqrt(x);

    }


    public int mySqrt_violence(int x) {
        if (x == 1) return 1;
        int res = 0;

        for (long i = 0; i <= x; i++) {
            if (i * i > x) {
                return (int) i - 1;
            }
        }

        return res;
    }

    public int mySqrt(int x) {
        if (x == 1) return 1;
        int res = 0;
        int left = 0, right = x, mid;

        while (left < right) {
            mid = (left + right) / 2;
            if (mid > 46341){
                right = 46341;
                continue;
            }

            long pow2 = mid * mid;
            if (pow2 < x) {
                left =  mid + 1;
                res = mid;
            } else if (pow2 > x) {
                right =  mid;
            } else {
                return mid;
            }
        }


        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T069().mySqrt(1));
        System.out.println(new T069().mySqrt(2));
        System.out.println(new T069().mySqrt(4));
        System.out.println(new T069().mySqrt(8));
        System.out.println(new T069().mySqrt(20));
        System.out.println(new T069().mySqrt(30));
        System.out.println(new T069().mySqrt(40));
        System.out.println(new T069().mySqrt(50));
        System.out.println(new T069().mySqrt(2147483647));
        System.out.println(new T069().mySqrt1(2147483647));
    }
}
