package edu.zju.zjh.topk.microsoft.d20220715;

/**
 * @author: zjh
 * @date : 2022/7/15 下午 07:22
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q001 {

    // you can also use imports, for example:
    // import java.util.*;

    // you can write to stdout for debugging purposes, e.g.
    // System.out.println("this is a debug message");

    class Solution {
        public int solution(String S) {
            // write your code in Java SE 8
            char[] cs = new char[128];
            int res = S.length();

            for (int i = 0; i < S.length(); i++) {
                cs[S.charAt(i)]++;
            }

            res = Math.min(res, cs['B']);
            res = Math.min(res, cs['A']);
            res = Math.min(res, cs['L'] / 2);
            res = Math.min(res, cs['O'] / 2);
            res = Math.min(res, cs['N']);

            return res;
        }
    }


}
