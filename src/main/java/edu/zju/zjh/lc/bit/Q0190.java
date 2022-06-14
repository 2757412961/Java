package edu.zju.zjh.lc.bit;

/**
 * @author: zjh
 * @date : 2022/6/14 15:45
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0190 {

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.1 MB,击败了9.07% 的Java用户
     */
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0, c = 0;

        while (c++ < 32) {
            res |= (n & 1) << (32 - c);
            n = n >>> 1;
        }

        return res;
    }

}
