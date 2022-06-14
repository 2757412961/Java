package edu.zju.zjh.lc.bit;

/**
 * @author: zjh
 * @date : 2022/6/14 16:33
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0231 {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }

}
