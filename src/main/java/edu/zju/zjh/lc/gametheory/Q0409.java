package edu.zju.zjh.lc.gametheory;

/**
 * @author: zjh
 * @date : 2022/7/25 21:43
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0409 {

    /**
     * 方法一：贪心
     * 执行耗时:2 ms,击败了62.54% 的Java用户
     * 内存消耗:39.5 MB,击败了79.43% 的Java用户
     */
    private class S1 {

        public int longestPalindrome(String s) {
            int res = 0;
            int[] cnts = new int[128];
            int carry = 0;

            for (int i = 0; i < s.length(); i++) {
                cnts[s.charAt(i)]++;
            }

            for (int i = 0; i < cnts.length; i++) {
                if (cnts[i] % 2 == 1) {
                    res += cnts[i] - 1;
                    carry = 1;
                } else {
                    res += cnts[i];
                }
            }

            return res + carry;
        }

    }

}
