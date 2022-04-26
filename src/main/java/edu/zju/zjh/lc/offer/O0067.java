package edu.zju.zjh.lc.offer;

/**
 * @author: zjh
 * @date : 2022/4/26 13:38
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0067 {

    public int strToInt(String str) {
        long res = 0;
        int flag = 1;
        boolean beBlank = true, beSymbol = true, beNumber = true;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ('0' <= c && c <= '9') {
                res = res * 10 + c - '0';

                beBlank = false;
                beSymbol = false;
            } else if (beBlank && c == ' ') {
            } else if (beSymbol && c == '-') {
                flag = -1;
                beBlank = false;
                beSymbol = false;
            } else if (beSymbol && c == '+') {
                flag = 1;
                beBlank = false;
                beSymbol = false;
            } else {
                break;
            }
            if (res > Integer.MAX_VALUE) {
                if (res * flag > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                if (res * flag < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }
        }

        return (int) (res * flag);
    }

    public static void main(String[] args) {
        System.out.println(new O0067().strToInt("2147483648"));
        System.out.println(new O0067().strToInt("9223372036854775808"));
        System.out.println(new O0067().strToInt("    0000000000012345678"));
    }

}
