package edu.zju.zjh.lc.offer;

/**
 * @author: zjh
 * @date : 2022/4/15 下午 07:54
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0058_I {

    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        String[] strs = s.trim().split(" ");

        for (int i = strs.length - 1; i >= 0; i--) {
            if (!"".equals(strs[i])) {
                res.append(strs[i]).append(' ');
            }
        }

        if (res.length() > 0) {
            res.deleteCharAt(res.length() - 1);
        }

        return res.toString();
    }

}
