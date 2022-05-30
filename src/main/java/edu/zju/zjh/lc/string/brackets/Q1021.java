package edu.zju.zjh.lc.string.brackets;

import java.util.LinkedList;

/**
 * @author: zjh
 * @date : 2022/5/30 14:29
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q1021 {

    /**
     * 方法一：栈
     */

    /**
     * 方法二：计数
     * <p>
     * 执行耗时:4 ms,击败了68.18% 的Java用户
     * 内存消耗:41.4 MB,击败了26.23% 的Java用户
     */
    public String removeOuterParentheses(String s) {
        StringBuilder str = new StringBuilder(s);
        StringBuilder sb = new StringBuilder();
        int start = 0, end = 0, num = 0;

        while (end < str.length()) {
            char c = str.charAt(end++);
            if (c == '(') {
                num++;
            } else if (c == ')') {
                num--;
                if (num == 0) {
                    sb.append(str.substring(start + 1, end - 1));
                    start = end;
                }
            }
        }

        return sb.toString();
    }

}
