package edu.zju.zjh.lcold;

public class T050 {
    public double myPow_violence(double x, int n) {
        double res = 1;
        boolean isZheng = true;

        if (n < 0) {
            n = -n;
            isZheng = false;
        }

        for (int i = 0; i < n; i++) {
            if (isZheng) {
                res *= x;
            } else {
                res /= x;
            }
        }


        return res;
    }


    public double myPow(double x, int n) {
        double rest = 1;
        long longN = n;

        if (longN < 0) {
            longN = -longN;
            x = 1 / x;
        } else if (n == 0) {
            return 1;
        }

        while (longN > 1) {
            if (longN % 2 == 1) {
                rest *= x;
            }

            x *= x;
            longN /= 2;
        }

        return rest * x;
    }


    public static void main(String[] args) {
//        System.out.println(new T050().myPow(2.1, -3));
//        System.out.println(new T050().myPow(1.00000, 2147483647));
        System.out.println(new T050().myPow(2.00000, -2147483648));
    }
}
