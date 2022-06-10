package edu.zju.zjh.offer;

/**
 * @author: zjh
 * @date : 2022/3/12 15:22
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0015 {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;

        while (n != 0) {
            n = n & (n - 1);
            res++;
        }

        return res;
    }

}
