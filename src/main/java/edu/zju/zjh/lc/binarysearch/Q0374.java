package edu.zju.zjh.lc.binarysearch;

/**
 * @author: zjh
 * @date : 2022/6/27 17:23
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0374 {

    public int guess(int num) {
        return 1;
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.5 MB,击败了8.53% 的Java用户
     */
    public int guessNumber(int n) {
        int l = 1, r = n, m = -1, g = 1;

        while (l <= r) {
            m = l + (r - l) / 2;
            g = guess(m);
            if (g == 0) {
                return m;
            } else if (g == 1) {
                l = m + 1;
            } else if (g == -1) {
                r = m - 1;
            }
        }

        return -1;
    }

}
