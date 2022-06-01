package edu.zju.zjh.lc.string.brackets;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author: zjh
 * @date : 2022/6/1 16:25
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0856 {

    /**
     * 方法一：分治
     * <p>
     * 执行耗时:1 ms,击败了44.73% 的Java用户
     * 内存消耗:39.6 MB,击败了5.35% 的Java用户
     */
    public int scoreRange(String s, int i, int j, Map<Integer, Integer> map) {
        if (i >= j) return 0;
        if (i + 1 == j) return 1;
        int sum = 0;

        while (i < j) {
            int end = map.get(i);
            if (i + 1 == end) {
                sum++;
            } else {
                sum += scoreRange(s, i, end, map) * 2;
            }
            i = end + 1;
        }

        return sum;
    }

    public int scoreOfParentheses(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.offerLast(i);
            } else {
                map.put(stack.pollLast(), i);
            }
        }

        return scoreRange(s, 0, s.length() - 1, map);
    }

    /**
     * 方法二：栈
     */

}
