package edu.zju.zjh.lc.string;

/**
 * @author: zjh
 * @date : 2022/5/25 19:58
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0008 {

    /**
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:41.2 MB,击败了64.56% 的Java用户
     */
    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        int idx = 0, n = chars.length, sign = 1, len = 0;
        long res = 0;

        // 判断前导空格
        for (; idx < n; idx++) {
            if (chars[idx] == ' ') {
                continue;
            }
            break;
        }

        // 判断符号
        if (idx < n) {
            if (chars[idx] == '+') {
                sign = 1;
                idx++;
            } else if (chars[idx] == '-') {
                sign = -1;
                idx++;
            }
        }

        // 字符串转整数
        for (; idx < n; idx++) {
            if (len > 10) break;
            if (!Character.isDigit(chars[idx])) break;

            if (res != 0) len++;
            res = 10 * res + chars[idx] - '0';
        }

        // 范围大小修正
        res = sign * res;
        if (res <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if (res >= Integer.MAX_VALUE) return Integer.MAX_VALUE;

        return ((int) res);
    }

}
