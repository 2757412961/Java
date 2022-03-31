package edu.zju.zjh.lc.ds.map;

import java.util.HashMap;
import java.util.Map;

public class Q0205 {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (!s2t.containsKey(sc)) {
                s2t.put(sc, tc);
            } else {
                if (!s2t.get(sc).equals(tc)) return false;
            }
            if (!t2s.containsKey(tc)) {
                t2s.put(tc, sc);
            } else {
                if (!t2s.get(tc).equals(sc)) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Q0205().isIsomorphic("badc", "baba"));
    }

}
