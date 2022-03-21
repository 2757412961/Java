package edu.zju.zjh.lc.string;

/**
 * @author: zjh
 * @date : 2022/3/19 15:06
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q005 {

    private int step(String s, int i, int j) {
        int step = 0;
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            i--;
            j++;
            step++;
        }

        return step;
    }

    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            step(s, i, i);
            step(s, i, i + 1);
        }

        return res;
    }

    public static void main(String[] args) {

    }

}
