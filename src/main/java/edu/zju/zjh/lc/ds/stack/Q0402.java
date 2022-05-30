package edu.zju.zjh.lc.ds.stack;

import java.util.LinkedList;

/**
 * @author: zjh
 * @date : 2022/5/30 10:38
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0402 {

    /**
     * 删除前一位数字大于后一位的。但没有找到太好的数据结构，链表或许可以
     * <p>
     * 执行耗时:7 ms,击败了91.89% 的Java用户
     * 内存消耗:41.4 MB,击败了86.17% 的Java用户
     */
    public String removeKdigits1(String num, int k) {
        int len = num.length();
        if (len <= k) return "0";

        StringBuilder sb = new StringBuilder(num);
        int idx = 0;

        while (k > 0) {
            if (idx >= sb.length() - 1) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            } else {
                if (sb.charAt(idx) > sb.charAt(idx + 1)) {
                    sb.deleteCharAt(idx);
                    k--;
                    while (idx > 0 && (sb.charAt(idx) < sb.charAt(idx - 1))) {
                        idx--;
                    }
                } else {
                    idx++;
                }
            }
        }

        idx = 0;
        while (idx < sb.length()) {
            if (sb.charAt(idx) != '0') {
                break;
            }
            idx++;
        }
        final String substring = sb.substring(idx);
        if (substring.length() == 0) return "0";
        return substring;
    }

    /**
     * 方法一：贪心 + 单调栈
     * <p>
     * 执行耗时:9 ms,击败了83.39% 的Java用户
     * 内存消耗:42.6 MB,击败了38.62% 的Java用户
     */
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (len <= k) return "0";

        LinkedList<Character> stack = new LinkedList<>();

        // 单调栈压入字符
        int idx = 0;
        while (idx < len) {
            char c = num.charAt(idx++);
            // 当还有字符容量可以删除，并且栈顶元素大于当前字符，出栈
            while (k > 0 && !stack.isEmpty() && stack.peekLast() > c) {
                stack.pollLast();
                k--;
            }
            stack.offer(c);
        }

        // 当还有字符容量可以删除，除去尾部
        while (k > 0 && !stack.isEmpty()) {
            stack.pollLast();
            k--;
        }

        // 除去前导零
        while (!stack.isEmpty()) {
            if (stack.peekFirst() != '0') {
                break;
            }
            stack.pollFirst();
        }

        // 合成字符串
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }
        if (sb.length() == 0) sb.append('0');

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Q0402().removeKdigits("112", 1));
        System.out.println(new Q0402().removeKdigits1("112", 1));
        System.out.println(new Q0402().removeKdigits("10200", 2));
        System.out.println(new Q0402().removeKdigits1("10200", 2));
        System.out.println(new Q0402().removeKdigits("10200", 1));
        System.out.println(new Q0402().removeKdigits1("10200", 1));
    }

}
