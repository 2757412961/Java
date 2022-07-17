package edu.zju.zjh.lc.ds.map;

import java.util.HashMap;
import java.util.Map;

public class Q0205 {

    /**
     * 方法一：哈希表
     * 执行耗时:19 ms,击败了38.99% 的Java用户
     * 内存消耗:41 MB,击败了88.52% 的Java用户
     */
    private class S1 {

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

    }

    /**
     * 方法二：字符数组
     * 执行耗时:5 ms,击败了91.00% 的Java用户
     * 内存消耗:41.1 MB,击败了70.90% 的Java用户
     */
    private class S2 {

        public boolean isIsomorphic(String s, String t) {
            char[] s2t = new char[256];
            char[] t2s = new char[256];
            for (int i = 0; i < s.length(); i++) {
                char cs = s.charAt(i);
                char ct = t.charAt(i);

                if (s2t[cs] == 0 && t2s[ct] == 0) {
                    s2t[cs] = ct;
                    t2s[ct] = cs;
                } else if (s2t[cs] != 0 && t2s[ct] != 0) {
                    if (s2t[cs] != ct || t2s[ct] != cs) {
                        return false;
                    }
                } else {
                    return false;
                }
            }

            return true;
        }

    }

    public static void main(String[] args) {
        System.out.println(new Q0205().new S1().isIsomorphic("badc", "baba"));
        System.out.println(new Q0205().new S2().isIsomorphic("badc", "baba"));

        System.out.println(new Q0205().new S1().isIsomorphic("egg", "add"));
        System.out.println(new Q0205().new S2().isIsomorphic("egg", "add"));
    }

}
