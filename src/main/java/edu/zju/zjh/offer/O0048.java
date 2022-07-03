package edu.zju.zjh.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zjh
 * @date : 2022/4/14 下午 05:20
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0048 {

    /**
     * 滑动窗口 + Map
     * 执行耗时:6 ms,击败了29.25% 的Java用户
     * 内存消耗:41.8 MB,击败了10.98% 的Java用户
     */
    private class S1 {

        public int lengthOfLongestSubstring(String s) {
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

    }

    /**
     * 滑动窗口 + 字符数组
     * 执行耗时:2 ms,击败了96.57% 的Java用户
     * 内存消耗:41.5 MB,击败了46.58% 的Java用户
     */
    private class S2 {

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

    }

    /**
     * 二刷
     * 执行耗时:2 ms,击败了96.57% 的Java用户
     * 内存消耗:41.6 MB,击败了29.57% 的Java用户
     */
    private class S3 {

        public int lengthOfLongestSubstring(String s) {
            int res = 0;
            int l = 0, r = 0;
            char[] cnts = new char[256];

            while (r < s.length()) {
                char cr = s.charAt(r++);
                cnts[cr]++;

                while (l < r && cnts[cr] > 1) {
                    char cl = s.charAt(l++);
                    cnts[cl]--;
                }

                res = Math.max(res, r - l);
            }

            return res;
        }

    }

    public static void main(String[] args) {
        System.out.println(new O0048().new S1().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new O0048().new S2().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new O0048().new S3().lengthOfLongestSubstring("abcabcbb"));
    }

}
