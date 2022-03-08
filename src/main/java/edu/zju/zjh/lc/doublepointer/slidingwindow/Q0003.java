package edu.zju.zjh.lc.doublepointer.slidingwindow;

/**
 * @author: zjh
 * @date : 2022/3/8 21:40
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0003 {

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
