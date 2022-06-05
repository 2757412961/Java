package edu.zju.zjh.lc.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author: zjh
 * @date : 2022/6/5 14:52
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0394 {

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.4 MB,击败了52.44% 的Java用户
     */
    public String decodeString(String s, int l, int r, Map<Integer, Integer> map) {
        if (l > r) return "";
        StringBuilder sb = new StringBuilder();
        int count = 0;

        while (l <= r) {
            char c = s.charAt(l);
            if (Character.isDigit(c)) {
                count = count * 10 + c - '0';
            } else if (c == '[') {
                String sub = decodeString(s, l + 1, map.get(l) - 1, map);
                while (count > 0) {
                    sb.append(sub);
                    count--;
                }
                l = map.get(l);
            } else {
                sb.append(c);
            }
            l++;
        }

        return sb.toString();
    }

    public String decodeString(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                stack.offerLast(i);
            }
            if (c == ']') {
                map.put(stack.pollLast(), i);
            }
        }

        return decodeString(s, 0, s.length() - 1, map);
    }

}
