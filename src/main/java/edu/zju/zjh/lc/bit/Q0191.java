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

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.8 MB,击败了7.57% 的Java用户
     */
    public class S2 {

        public int hammingWeight(int n) {
            int res = 0;
            while (n != 0) {
                n = n & (n - 1);
                res++;
            }

            return res;
        }

    }

}
