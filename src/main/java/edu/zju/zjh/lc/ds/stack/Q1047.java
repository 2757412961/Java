package edu.zju.zjh.lc.ds.stack;

/**
 * @author: zjh
 * @date : 2022/6/28 19:29
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q1047 {

    /**
     * 方法一：栈
     * 执行耗时:11 ms,击败了84.27% 的Java用户
     * 内存消耗:41.6 MB,击败了85.34% 的Java用户
     */
    public String removeDuplicates(String s) {
        StringBuilder res = new StringBuilder(s.length());

        for (int i = 0; i < s.length(); i++) {
            int len = res.length();
            char c = s.charAt(i);
            if (len > 0 && res.charAt(len - 1) == c) {
                res.deleteCharAt(len - 1);
            } else {
                res.append(c);
            }
        }

        return res.toString();
    }

}
