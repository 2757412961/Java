package edu.zju.zjh.lc.string;

/**
 * @author: zjh
 * @date : 2022/6/1 10:12
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0557 {

    /**
     * 执行耗时:3 ms,击败了90.78% 的Java用户
     * 内存消耗:42.1 MB,击败了15.84% 的Java用户
     */
    public void reverseChars(char[] cs, int l, int r) {
        if (l > r) return;
        while (l < r) {
            char temp = cs[l];
            cs[l++] = cs[r];
            cs[r--] = temp;
        }
    }

    public String reverseWords(String s) {
        char[] cs = s.toCharArray();
        int l = 0, r = l;

        while (l < cs.length) {
            if (cs[l] == ' ') {
                l++;
                continue;
            }

            r = l;
            while (r < cs.length && cs[r] != ' ') {
                r++;
            }
            reverseChars(cs, l, r - 1);
            l = r;
        }

        return new String(cs);
    }

}
