package edu.zju.zjh.offer;

/**
 * @author: zjh
 * @date : 2022/3/8 22:02
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0046 {

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
