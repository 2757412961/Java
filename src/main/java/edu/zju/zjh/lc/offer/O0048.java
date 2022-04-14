package edu.zju.zjh.lc.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zjh
 * @date : 2022/4/14 下午 05:20
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0048 {

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        char[] cs = s.toCharArray();
        int i = 0, j = 0, n = cs.length;
        Map<Character, Integer> map = new HashMap<>();

        while (j < n) {

            j++;

            while (i<j){

                i++;
            }
        }

        return res;
    }

}
