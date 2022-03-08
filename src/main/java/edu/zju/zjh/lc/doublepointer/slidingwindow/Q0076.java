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
