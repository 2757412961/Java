package main.java.edu.zju.zjh.lcold;

public class T461 {
    public int hammingDistance(int x, int y) {
        int res = 0;

        while (x > 0 && y > 0) {
            if (x % 2 != y % 2) {
                res++;
            }

            x /= 2;
            y /= 2;
        }

        while (x > 0) {
            if (x % 2 != 0) {
                res++;
            }

            x /= 2;
        }

        while (y > 0) {
            if (y % 2 != 0) {
                res++;
            }

            y /= 2;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T461().hammingDistance(1, 4));
    }
}
