package edu.zju.zjh.offer;

import javax.management.Query;
import java.util.*;

/**
 * @author: zjh
 * @date : 2022/4/15 上午 11:18
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0050 {

    /**
     * 方法一：使用哈希表存储频数
     * LinkedHashMap 保证顺序
     * 执行耗时:23 ms,击败了46.97% 的Java用户
     * 内存消耗:41.9 MB,击败了41.01% 的Java用户
     */
    private class S1 {

        public char firstUniqChar(String s) {
            char[] cs = s.toCharArray();
            LinkedHashMap<Character, Integer> map = new LinkedHashMap();

            for (int i = 0; i < cs.length; i++) {
                map.put(cs[i], map.getOrDefault(cs[i], 0) + 1);
            }

            Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Character, Integer> next = iterator.next();
                if (next.getValue() == 1) return next.getKey();
            }

            return ' ';
        }

    }

    /**
     * 方法三：队列
     * 执行耗时:8 ms,击败了74.81% 的Java用户
     * 内存消耗:41.6 MB,击败了75.48% 的Java用户
     */
    private class S2 {

        public char firstUniqChar(String s) {
            char[] cs = new char[256];
            Queue<Character> q = new LinkedList<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                cs[c]++;
                if (cs[c] == 1) {
                    q.offer(c);
                }
                while (!q.isEmpty() && cs[q.peek()] > 1) {
                    q.poll();
                }
            }

            return q.isEmpty() ? ' ' : q.peek();
        }

    }

}
