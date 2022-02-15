package edu.zju.zjh.lcold;

import java.util.Stack;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/8/14 下午 01:38
 * @Modified_By :
 */
public class T020 {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;
        Stack<Character> stack = new Stack<>();
        stack.push('0');

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                char top = stack.peek();
                if (ch == ')' && top == '(') {
                    stack.pop();
                    continue;
                }
                if (ch == '}' && top == '{') {
                    stack.pop();
                    continue;
                }
                if (ch == ']' && top == '[') {
                    stack.pop();
                    continue;
                }

                return false;
            }
        }

        return stack.size() == 1;
    }


    public static void main(String[] args) {
//        给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
//        有效字符串需满足：
//        左括号必须用相同类型的右括号闭合。
//        左括号必须以正确的顺序闭合。
//        注意空字符串可被认为是有效字符串。
//
//        示例 1:
//
//        输入: "()"
//        输出: true
//        示例 2:
//
//        输入: "()[]{}"
//        输出: true
//        示例 3:
//
//        输入: "(]"
//        输出: false
//        示例 4:
//
//        输入: "([)]"
//        输出: false
//        示例 5:
//
//        输入: "{[]}"
//        输出: true


//        String s = "{[]}";
        String s = "{[}]";

        System.out.println(new T020().isValid(s));
    }
}
