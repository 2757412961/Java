package edu.zju.zjh.lc.binarysearch;

/**
 * @author: zjh
 * @date : 2022/6/28 15:47
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0744 {

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.7 MB,击败了51.03% 的Java用户
     */
    private class S1 {

        public char nextGreatestLetter(char[] letters, char target) {
            int l = 0, r = letters.length, m = -1;

            while (l < r) {
                m = l + (r - l) / 2;
                if (letters[m] == target) {
                    l = m + 1;
                } else if (letters[m] > target) {
                    r = m;
                } else if (letters[m] < target) {
                    l = m + 1;
                }
            }

            return l == letters.length ? letters[0] : letters[l];
        }

    }

}
