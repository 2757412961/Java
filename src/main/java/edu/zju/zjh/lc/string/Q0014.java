package edu.zju.zjh.lc.string;

/**
 * @author: zjh
 * @date : 2022/6/2 20:38
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0014 {

    /**
     * 执行耗时:1 ms,击败了69.16% 的Java用户
     * 内存消耗:39.1 MB,击败了81.42% 的Java用户
     */
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();

        int pos = 0;
        while (pos < strs[0].length()) {
            char c = strs[0].charAt(pos);
            for (int i = 1; i < strs.length; i++) {
                if (pos >= strs[i].length() || strs[i].charAt(pos) != c) {
                    return res.toString();
                }
            }
            res.append(c);
            pos++;
        }

        return res.toString();
    }

}
