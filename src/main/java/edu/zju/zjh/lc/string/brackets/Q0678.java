package edu.zju.zjh.lc.string.brackets;

import java.util.LinkedList;

/**
 * @author: zjh
 * @date : 2022/6/7 16:06
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0678 {

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.4 MB,击败了32.61% 的Java用户
     */
    public boolean checkValidString(String s) {
        LinkedList<Integer> left = new LinkedList<>();
        LinkedList<Integer> star = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (c == '*') {
                star.offerLast(i);
            } else if (c == '(') {
                left.offerLast(i);
            } else if (c == ')') {
                if (!left.isEmpty()) {
                    left.pollLast();
                } else {
                    if (star.isEmpty()) return false;
                    star.pollLast();
                }
            }
        }

        while (!left.isEmpty() && !star.isEmpty()) {
            Integer l = left.pollLast();
            Integer sr = star.pollLast();
            if (sr < l) return false;
        }

        return left.isEmpty();
    }

}
