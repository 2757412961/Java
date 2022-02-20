package edu.zju.zjh.lc.string;

/**
 * @author: zjh
 * @date : 2022/2/20 21:48
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0028 {

    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        int[] next = new int[m];
        int l = 0, r = 0;

        if (needle.isEmpty()) return 0;

        next[0] = 0;
        for (r = 1; r < m; r++) {
            while (l > 0 && needle.charAt(l) != needle.charAt(r)) {
                l = next[l - 1];
            }
            if (needle.charAt(l) == needle.charAt(r)) {
                l++;
            }

            next[r] = l;
        }

        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - j + 1;
            }
        }

        return -1;
    }

}
