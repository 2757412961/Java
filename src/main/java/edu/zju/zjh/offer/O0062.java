package edu.zju.zjh.offer;

/**
 * @author: zjh
 * @date : 2022/4/24 12:48
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0062 {

    public int lastRemaining(int n, int m) {
        int idx = 0;

        for (int i = 2; i <= n; i++) {
            idx = (idx + m) % i;
        }

        return idx;
    }

    /**
     * recursive
     */
    public int f(int n, int k) {
        if (n == 1) return 0;

        return (f(n - 1, k) + k) % n;
    }

    public static void main(String[] args) {
        System.out.println(new O0062().lastRemaining(5, 3));
        System.out.println(new O0062().f(5, 3));
        System.out.println(new O0062().f(9, 3));

    }

}
