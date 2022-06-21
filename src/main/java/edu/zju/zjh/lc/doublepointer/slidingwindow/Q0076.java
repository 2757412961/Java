package edu.zju.zjh.lc.doublepointer.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zjh
 * @date : 2022/3/8 19:22
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0076 {

    /**
     * 方法一：滑动窗口
     */
    private class S1 {

        public String minWindow(String s, String t) {
            if (s == null || s == "" || t == null || t == "" || s.length() < t.length()) {
                return "";
            }

            Map<Character, Integer> need = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();
            int left = 0, right = 0;
            int start = -1, len = Integer.MAX_VALUE, valid = 0;

            for (int i = 0; i < t.length(); i++) {
                char ch = t.charAt(i);
                need.put(ch, need.getOrDefault(ch, 0) + 1);
                window.put(ch, 0);
            }

            while (right < s.length()) {
                char chr = s.charAt(right);
                right++;
                if (window.containsKey(chr)) {
                    window.put(chr, window.get(chr) + 1);
                    if (window.get(chr).equals(need.get(chr))) {
                        valid++;
                    }
                }

                while (valid == need.size()) {
                    if (right - left < len) {
                        start = left;
                        len = right - left;
                    }

                    char chl = s.charAt(left);
                    left++;
                    if (window.containsKey(chl)) {
                        if (window.get(chl).equals(need.get(chl))) {
                            valid--;
                        }
                        window.put(chl, window.get(chl) - 1);
                    }
                }
            }

            if (start < 0) return "";
            return s.substring(start, start + len);
        }

    }

    /**
     * 二刷
     * 滑动窗口+数组
     * 执行耗时:2 ms,击败了96.13% 的Java用户
     * 内存消耗:41.7 MB,击败了66.81% 的Java用户
     */
    private class S2 {

        public String minWindow(String s, String t) {
            int[] window = new int[128];
            int[] needs = new int[128];
            int valid = 0, count = 0;
            int l = 0, r = 0;
            int start = 0, len = Integer.MAX_VALUE;

            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                if (needs[c] == 0) count++;
                needs[c]++;
            }

            while (r < s.length()) {
                char cr = s.charAt(r++);
                if (needs[cr] > 0) {
                    window[cr]++;
                    if (window[cr] == needs[cr]) {
                        valid++;
                    }
                }

                while (l < r && valid == count) {
                    if (r - l < len) {
                        start = l;
                        len = r - l;
                    }

                    char cl = s.charAt(l++);
                    if (needs[cl] > 0) {
                        if (window[cl] == needs[cl]) {
                            valid--;
                        }
                        window[cl]--;
                    }
                }
            }

            if (len == Integer.MAX_VALUE) return "";
            return s.substring(start, start + len);
        }

    }

}
