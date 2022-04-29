package edu.zju.zjh.topk.ali;

/**
 * @author: zjh
 * @date : 2022/4/29 20:51
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0003 {

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int i = 0, j = 0;
        int[] chars = new int[128];

        while (j < s.length()) {
            char chj = s.charAt(j);
            chars[chj]++;

            while (chars[chj] > 1) {
                chars[s.charAt(i)]--;
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q0003().lengthOfLongestSubstring("abcabcbb"));
    }

}
