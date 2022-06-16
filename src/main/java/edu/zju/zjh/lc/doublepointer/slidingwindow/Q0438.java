package edu.zju.zjh.lc.doublepointer.slidingwindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: zjh
 * @date : 2022/3/8 20:31
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0438 {

    private class S1 {

        public List<Integer> findAnagrams(String s, String p) {
            if (s.length() < p.length()) return new ArrayList<>();
            List<Integer> res = new ArrayList<>();
            int[] need = new int[128];
            int[] window = new int[128];
            int left = 0, right = 0, valid = 0, validAll = 0;

            for (int i = 0; i < p.length(); i++) {
                char c = p.charAt(i);
                if (need[c] == 0) {
                    validAll++;
                }
                need[c]++;
            }

            for (right = 0; right < p.length(); right++) {
                char c = s.charAt(right);
                if (need[c] > 0) {
                    window[c]++;
                    if (need[c] == window[c]) {
                        valid++;
                    }
                }
            }

            if (valid == validAll) {
                res.add(left);
            }
            while (right < s.length()) {
                char chl = s.charAt(left++);
                if (need[chl] > 0) {
                    if (window[chl] == need[chl]) {
                        valid--;
                    }
                    window[chl]--;
                }
                char chr = s.charAt(right++);
                if (need[chr] > 0) {
                    window[chr]++;
                    if (window[chr] == need[chr]) {
                        valid++;
                    }
                }

                if (valid == validAll) {
                    res.add(left);
                }
            }

            return res;
        }

    }

    /**
     * 执行耗时:7 ms,击败了86.58% 的Java用户
     * 内存消耗:42.8 MB,击败了8.53% 的Java用户
     */
    private class S2 {

        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new LinkedList<>();
            int[] need = new int[128];
            int[] window = new int[128];
            int count = 0, needs = 0, l = 0, r = 0;

            for (int i = 0; i < p.length(); i++) {
                char c = p.charAt(i);
                if (need[c] == 0) needs++;
                need[c]++;
            }

            while (r < s.length()) {
                char cr = s.charAt(r++);
                if (need[cr] > 0) {
                    window[cr]++;
                    if (window[cr] == need[cr]) {
                        count++;
                    }
                }

                while (r - l > p.length()) {
                    char cl = s.charAt(l++);
                    if (need[cl] > 0) {
                        if (window[cl] == need[cl]) {
                            count--;
                        }
                        window[cl]--;
                    }
                }

                if (r - l == p.length() && count == needs) {
                    res.add(l);
                }
            }

            return res;
        }

    }

}
