package edu.zju.zjh.lc.string;

/**
 * @author: zjh
 * @date : 2022/7/19 9:21
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0242 {

    /**
     * 执行耗时:4 ms,击败了36.79% 的Java用户
     * 内存消耗:41.7 MB,击败了33.08% 的Java用户
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] cs = new int[128];

        for (int i = 0; i < s.length(); i++) {
            cs[s.charAt(i)]++;
            cs[t.charAt(i)]--;
        }

        for (int i = 95; i < 128; i++) {
            if (cs[i] != 0) return false;
        }

        return true;
    }

}
