package edu.zju.zjh.lc.doublepointer.slidingwindow;

/**
 * @author: zjh
 * @date : 2022/4/29 20:51
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0003 {

    private class S1 {

        public int lengthOfLongestSubstring(String s) {
            int[] window = new int[128];
            int left = 0, right = 0, valid = 0, len = 0;

            while (right < s.length()) {
                char chr = s.charAt(right++);
                if (window[chr] == 1) {
                    valid++;
                }
                window[chr]++;

                while (valid != 0) {
                    char chl = s.charAt(left++);
                    window[chl]--;
                    if (window[chl] == 1) {
                        valid--;
                    }
                }

                len = Math.max(len, right - left);
            }

            return len;
        }

    }

    private class S2 {

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

    }

    public static void main(String[] args) {
        System.out.println(new Q0003().new S1().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Q0003().new S2().lengthOfLongestSubstring("abcabcbb"));
    }

}
