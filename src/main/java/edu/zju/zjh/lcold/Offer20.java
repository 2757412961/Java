package main.java.edu.zju.zjh.lcold;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/8/29 下午 03:53
 * @Modified_By :
 */
public class Offer20 {
    public boolean isNumber(String s) {
        if (s.length() <= 0) return false;
        int add = 0, sub = 0, poi = 0, eno = 0, other = 0;
        s = s.toLowerCase();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '+') {
                add++;
            } else if (ch == '-') {
                sub++;
            } else if (ch == '.') {
                poi++;
            } else if (ch == 'e') {
                eno++;
            } else {
                other++;
            }
        }

        if (other > 0 && poi >= 2 && eno >= 2) return false;

        if (s.length() >= 2 && s.charAt(0) == '0' && '0' <= s.charAt(1) && s.charAt(1) <= '9') {
            return false;
        }

        if (eno == 1) {
            int ei = s.indexOf('e');


        }

        return true;
    }

    public static void main(String[] args) {
//        请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
//        例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。

        String[] tests = new String[]{
                "+1E00", "5e2", "-123", "3.1416", "-1E-16",
                "0123", "12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"
        };

        for (int i = 0; i < tests.length; i++) {
            System.out.println(new Offer20().isNumber(tests[i]));
        }
    }
}
