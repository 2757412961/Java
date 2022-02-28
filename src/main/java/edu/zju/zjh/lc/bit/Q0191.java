package edu.zju.zjh.lc.bit;

/**
 * @author: zjh
 * @date : 2022/2/28 11:51
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0191 {

    public int hammingWeight(int n) {
        int res = 0;

        while (n != 0) {
            n = n & (n - 1);
            res++;
        }

        return res;
    }

}
