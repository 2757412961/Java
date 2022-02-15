package edu.zju.zjh.lcold;

import java.util.HashSet;
import java.util.Set;

public class T003 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int i = 0, j = 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();

        while (i < n && j < n) {
            char ch = s.charAt(j);
            if (!set.contains(ch)) {
                set.add(ch);
                j++;
                res = Math.max(res, j - i);
                continue;
            } else {
                while (i <= j) {
                    char chi = s.charAt(i);
                    set.remove(chi);
                    i++;
                    if (chi == ch) {
                        break;
                    }
                }
            }

            res = Math.max(res, j - i);
        }

        return res;
    }


    public static void main(String[] args) {
        new T003().lengthOfLongestSubstring("abcabcbb");
    }
}
