package edu.zju.zjh.lc.ds.stack.calculate;

import java.util.LinkedList;

/**
 * @author: zjh
 * @date : 2022/6/7 17:02
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0227 {

    /**
     * 加减乘除（不包含括号）
     * https://labuladong.github.io/algo/4/31/127/
     * 执行耗时:6 ms,击败了97.32% 的Java用户
     * 内存消耗:44.6 MB,击败了14.07% 的Java用户
     */
    public int calculate(String s) {
        int res = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        char sign = '+';
        int num = 0;

        s += "+0";
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if ((!Character.isWhitespace(c) && !Character.isDigit(c)) || i == s.length() - 1) {
                if (sign == '+') {
                    stack.offerLast(num);
                } else if (sign == '-') {
                    stack.offerLast(-num);
                } else if (sign == '*') {
                    Integer prev = stack.pollLast();
                    stack.offerLast(prev * num);
                } else if (sign == '/') {
                    Integer prev = stack.pollLast();
                    stack.offerLast(prev / num);
                }
                num = 0;
                sign = c;
            }
        }

        while (!stack.isEmpty()) {
            res += stack.pollLast();
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q0227().calculate(" 3 - 20+5 - 2 "));
        System.out.println(new Q0227().calculate(" 3 - 20+5 - 2 +9 "));
        System.out.println(new Q0227().calculate("   3+ 20*2 - 2 "));
    }

}
