package edu.zju.zjh.lc.binarysearch;

/**
 * @author: zjh
 * @date : 2022/5/16 14:08
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0278 {

    public boolean isBadVersion(int version) {
        return true;
    }

    /**
     * 执行耗时:11 ms,击败了99.96% 的Java用户
     * 内存消耗:38.3 MB,击败了34.26% 的Java用户
     */
    public int firstBadVersion(int n) {
        long l = 1, r = 1L + n;
        int m = -1;

        while (l < r) {
            m = (int) ((r - l) / 2 + l);
            if (isBadVersion(m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return (int) l;
    }

}
