package edu.zju.zjh.lc.dp;

/**
 * @author: zjh
 * @date : 2022/3/12 11:41
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0014_II {

    public int cuttingRope(int n) {
        if (n < 4) return n - 1;
        long res = 1;

        while (n > 4) {
            res = (res * 3) % 1000000007;
            n -= 3;
        }

        return (int) (res * n % 1000000007);
    }

}
