package edu.zju.zjh.lc.doublepointer.slidingwindow;

/**
 * @author: zjh
 * @date : 2022/7/12 21:44
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0392 {

    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        int si = 0, ti = 0;

        while (si < m && ti < n) {
            if (s.charAt(si) == t.charAt(ti)) {
                si++;
            }

            ti++;
        }

        return si == m;
    }

}
