package main.java.edu.zju.zjh.lcold;

import java.util.HashMap;
import java.util.Map;

public class T395 {
    public int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character, Integer> entries : map.entrySet()) {
            if (entries.getValue() < k) {
                int res = 0;
                for (String ss : s.split(String.valueOf(entries.getKey()))) {
                    res = Math.max(res, longestSubstring(ss, k));
                }

                return res;
            }
        }

        return s.length();
    }

    public static void main(String[] args) {
//        示例 1：
//        输入：s = "aaabb", k = 3
//        输出：3
//        解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
//
//        示例 2：
//        输入：s = "ababbc", k = 2
//        输出：5
//        解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。

        String s = "ababbc";
        int k = 2;

        System.out.println(new T395().longestSubstring(s, k));
    }
}
