package edu.zju.zjh.lc.string;

/**
 * @author: zjh
 * @date : 2022/3/19 15:06
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0005 {

    private int left = 0;
    private int right = 1;
    private int len = 0;

    private void step(String s, int i, int j) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            if (j - i > len) {
                len = j - i;
                left = i;
                right = j + 1;
            }
            i--;
            j++;
        }
    }

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            step(s, i, i);
            step(s, i, i + 1);
        }

        return s.substring(left, right);
    }

    public static void main(String[] args) {
        System.out.println(new Q0005().longestPalindrome("aasd"));
        System.out.println(new Q0005().longestPalindrome("badad"));
    }

    /**
     * 执行耗时:10 ms,击败了92.23% 的Java用户
     * 内存消耗:41.2 MB,击败了83.91% 的Java用户
     */
    private class S2 {

        private int l = 0, r = 0, len = 0;

        public void find(char[] cs, int i, int j) {
            while (0 <= i && j < cs.length && cs[i] == cs[j]) {
                if (j - i + 1 > len) {
                    l = i;
                    r = j + 1;
                    len = r - l;
                }

                i--;
                j++;
            }
        }

        public String longestPalindrome(String s) {
            final char[] cs = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                find(cs, i, i);
                find(cs, i, i + 1);
            }

            return s.substring(l, r);
        }

    }

}
