package edu.zju.zjh.lc.ds.map;

/**
 * @author: zjh
 * @date : 2022/7/25 20:42
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q2351 {

    /**
     * HashSet
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.5 MB,击败了100.00% 的Java用户
     */
    public char repeatedCharacter(String s) {
        int[] cnts = new int[128];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cnts[c] >= 1) return c;
            cnts[c]++;
        }

        return ' ';
    }

}
