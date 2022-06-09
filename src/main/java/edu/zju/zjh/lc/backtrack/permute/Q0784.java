package edu.zju.zjh.lc.backtrack.permute;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zjh
 * @date : 2022/6/9 13:49
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0784 {

    /**
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:42.3 MB,击败了16.97% 的Java用户
     */
    public List<String> permute(char[] cs, int pos, List<String> res) {
        if (pos == cs.length) return res;

        char c = cs[pos];
        if (Character.isDigit(c)) {
            permute(cs, pos + 1, res);
        } else if (Character.isLetter(c)) {
            permute(cs, pos + 1, res);

            cs[pos] = Character.toUpperCase(c);
            res.add(new String(cs));
            permute(cs, pos + 1, res);
            cs[pos] = Character.toLowerCase(c);
        }

        return res;
    }

    public List<String> letterCasePermutation(String s) {
        final char[] cs = s.toLowerCase().toCharArray();

        final ArrayList<String> res = new ArrayList<>();
        res.add(new String(cs));
        return permute(cs, 0, res);
    }

}
