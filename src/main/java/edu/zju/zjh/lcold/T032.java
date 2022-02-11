package main.java.edu.zju.zjh.lcold;

import java.util.Stack;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/7/4 下午 05:51
 * @Modified_By :
 */
public class T032 {
    public int longestValidParentheses_stack(String s) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                int top = stack.pop();
                if (top == -1) {
                    stack.push(i);
                } else if (s.charAt(top) == '(') {
                    res = Math.max(res, i - stack.peek());
                } else if (s.charAt(top) == ')') {
                    stack.push(i);
                }
            }
        }

        return res;
    }

    public int longestValidParentheses(String s) {
        int res = 0;
        int left = 0, righ = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                righ++;
            }

            if (left < righ) {
                left = righ = 0;
            } else if (left == righ) {
                res = Math.max(res, left * 2);
            }
        }

        left = righ = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                righ++;
            } else {
                left++;
            }

            if (left > righ) {
                left = righ = 0;
            } else if (left == righ) {
                res = Math.max(res, left * 2);
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
//
//        示例 1:
//
//        输入: "(()"
//        输出: 2
//        解释: 最长有效括号子串为 "()"
//        示例 2:
//
//        输入: ")()())"
//        输出: 4
//        解释: 最长有效括号子串为 "()()"

        String s = ")()())";
//        String s = "()(()";

        System.out.println(new T032().longestValidParentheses(s));
        System.out.println(new T032().longestValidParentheses_stack(s));
    }
}
