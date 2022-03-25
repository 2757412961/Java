package edu.zju.zjh.lc.greddy;

import java.util.Arrays;

public class Q0455 {

    public int findContentChildren(int[] g, int[] s) {
        int res = 0, i = g.length - 1, j = s.length - 1;

        Arrays.sort(g);
        Arrays.sort(s);

        while (i >= 0 && j >= 0) {
            if (s[j] >= g[i]) {
                j--;
                res++;
            }
            i--;
        }

        return res;
    }

}
