package edu.zju.zjh.lc.ds.map;

import java.util.HashMap;
import java.util.Map;

public class Q0290 {

    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        if (pattern.length() != strs.length) return false;

        Map<Character, String> p2s = new HashMap<>();
        Map<String, Character> s2p = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char p = pattern.charAt(i);
            String str = strs[i];

            if (!p2s.containsKey(p)) {
                p2s.put(p, str);
            } else {
                if (!p2s.get(p).equals(str)) return false;
            }
            if (!s2p.containsKey(str)) {
                s2p.put(str, p);
            } else {
                if (!s2p.get(str).equals(p)) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Q0290().wordPattern("abba", "a b b a"));
    }

}
