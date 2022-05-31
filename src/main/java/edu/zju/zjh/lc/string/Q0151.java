package edu.zju.zjh.lc.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: zjh
 * @date : 2022/5/31 15:49
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0151 {

    /**
     * 执行耗时:6 ms,击败了62.23% 的Java用户
     * 内存消耗:41.1 MB,击败了74.39% 的Java用户
     */
    public String reverseWords(String s) {
        // 如果字符串在你使用的编程语言中是一种可变数据类型，请尝试使用 O(1) 额外空间复杂度的 原地 解法。
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (sb.length() > 0) {
                    list.add(sb.toString());
                }
                sb.delete(0, sb.length());
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) {
            list.add(sb.toString());
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            res.append(list.get(i));
            if (i > 0) {
                res.append(' ');
            }
        }

        return res.toString();
    }

}
