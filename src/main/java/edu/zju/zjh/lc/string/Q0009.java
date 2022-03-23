package edu.zju.zjh.lc.string;

/**
 * @author: zjh
 * @date : 2022/3/22 上午 09:39
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0009 {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int r = 0, c = x;

        while (c != 0) {
            r = r * 10 + c % 10;
            c /= 10;
        }

        return x == r;
    }
}
