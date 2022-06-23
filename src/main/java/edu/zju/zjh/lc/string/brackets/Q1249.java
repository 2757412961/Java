package edu.zju.zjh.lc.string.brackets;

import java.util.LinkedList;

/**
 * @author: zjh
 * @date : 2022/6/23 下午 03:24
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q1249 {

    /**
     * 方法一：使用栈和 StringBuilder
     * 执行耗时:18 ms,击败了69.15% 的Java用户
     * 内存消耗:42.7 MB,击败了8.19% 的Java用户
     */
    public String minRemoveToMakeValid(String s) {
        StringBuilder res = new StringBuilder(s.length());
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(res.length());
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    continue;
                }
                stack.pop();
            }
            res.append(c);
        }

        while (!stack.isEmpty()) {
            res.deleteCharAt(stack.pop());
        }

        return res.toString();
    }

}
