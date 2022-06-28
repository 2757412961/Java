package edu.zju.zjh.lc.dp;

/**
 * @author: zjh
 * @date : 2022/6/28 19:39
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q1137 {

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.2 MB,击败了42.19% 的Java用户
     */
    public int tribonacci(int n) {
        if (n <= 1) return n;
        if (n == 2) return 1;
        int t0 = 0, t1 = 1, t2 = 1, now = 0;

        for (int i = 3; i <= n; i++) {
            now = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = now;
        }

        return now;
    }

}
