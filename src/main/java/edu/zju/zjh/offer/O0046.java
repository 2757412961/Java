package edu.zju.zjh.offer;

/**
 * @author: zjh
 * @date : 2022/3/8 22:02
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0046 {

    private class S1 {

        public int translateNum(int num) {
            if (num < 10) return 1;
            String s = String.valueOf(num);

            int dp0 = 1, dp1 = 1, dp2 = 1;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) <= '5') {
                    dp2 = dp1 + dp0;
                } else {
                    dp2 = dp1;
                }
                dp0 = dp1;
                dp1 = dp2;
            }

            return dp2;
        }

    }

    /**
     * 二刷
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38 MB,击败了87.19% 的Java用户
     */
    private class S2 {

        public int translateNum(int num) {
            int dp0 = 1, dp1 = 1, dp2 = 1;
            char[] chars = String.valueOf(num).toCharArray();

            for (int i = 1; i < chars.length; i++) {
                char c0 = chars[i - 1];
                char c1 = chars[i];
                if (c0 == '1' || (c0 == '2' && '0' <= c1 && c1 <= '5')) {
                    dp2 = dp0 + dp1;
                } else {
                    dp2 = dp1;
                }
                dp0 = dp1;
                dp1 = dp2;
            }

            return dp2;
        }

    }

}
