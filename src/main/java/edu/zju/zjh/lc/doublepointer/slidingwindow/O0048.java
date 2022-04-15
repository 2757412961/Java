package edu.zju.zjh.lc.doublepointer.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zjh
 * @date : 2022/4/14 下午 05:20
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0048 {

    public int lengthOfLongestSubstring0(String s) {
        int res = 0;
        char[] cs = s.toCharArray();
        int i = 0, j = 0, n = cs.length;
        Map<Character, Integer> map = new HashMap<>();

        while (j < n) {
            map.put(cs[j], map.getOrDefault(cs[j], 0) + 1);
            j++;

            while (1 < map.getOrDefault(cs[j - 1], 0)) {
                map.put(cs[i], map.getOrDefault(cs[i], 0) - 1);
                i++;
            }
            res = Math.max(res, j - i);
        }

        return res;
    }

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        char[] cs = s.toCharArray();
        int i = 0, j = 0, n = cs.length;
        int[] map = new int[256];

        while (j < n) {
            map[cs[j]]++;
            j++;

            while (1 < map[cs[j - 1]]) {
                map[cs[i]]--;
                i++;
            }
            res = Math.max(res, j - i);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new O0048().lengthOfLongestSubstring0("abcabcbb"));
        System.out.println(new O0048().lengthOfLongestSubstring("abcabcbb"));
    }

}
