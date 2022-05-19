package edu.zju.zjh.lc.string;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author: zjh
 * @date : 2022/5/18 10:59
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q1190 {

    /**
     * 官方答案
     */
    public String reverseParenthesesAns(String s) {
        int n = s.length();
        int[] pair = new int[n];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        StringBuffer sb = new StringBuffer();
        int index = 0, step = 1;
        while (index < n) {
            if (s.charAt(index) == '(' || s.charAt(index) == ')') {
                index = pair[index];
                step = -step;
            } else {
                sb.append(s.charAt(index));
            }
            index += step;
        }
        return sb.toString();
    }

    /**
     * 执行耗时:1 ms,击败了97.81% 的Java用户
     * 内存消耗:39.5 MB,击败了62.31% 的Java用户
     */
    Map<Integer, Integer> to = new HashMap<>();

    public String reverseParentheses(char[] chars, int l, int r, int level) {
        if (l > r) return "";
        StringBuilder sb = new StringBuilder();
        int i = l;

        if (level % 2 == 1) {
            while (i <= r) {
                if (chars[i] == '(') {
                    int j = to.get(i);
                    sb.insert(0, reverseParentheses(chars, i + 1, j - 1, level + 1));
                    i = j + 1;
                    continue;
                }
                sb.insert(0, chars[i]);
                i++;
            }
        } else if (level % 2 == 0) {
            while (i <= r) {
                if (chars[i] == '(') {
                    int j = to.get(i);
                    sb.append(reverseParentheses(chars, i + 1, j - 1, level + 1));
                    i = j + 1;
                    continue;
                }
                sb.append(chars[i]);
                i++;
            }
        }

        return sb.toString();
    }

    public String reverseParentheses(String s) {
        char[] chars = s.toCharArray();
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else if (chars[i] == ')') {
                to.put(stack.pop(), i);
            }
        }

        return reverseParentheses(chars, 0, s.length() - 1, 0);
    }

    public static void main(String[] args) {
        System.out.println(new Q1190().reverseParenthesesAns("(w(ab)c(cd)err)"));
        System.out.println(new Q1190().reverseParentheses("(w(ab)c(cd)err)"));
    }

}
