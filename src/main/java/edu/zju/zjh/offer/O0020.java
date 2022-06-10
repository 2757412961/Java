package edu.zju.zjh.offer;

/**
 * @author: zjh
 * @date : 2022/3/4 15:40
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0020 {

    // 2.正则表达式
    public boolean isNumber(String s) {
        String blankRegex = " *";
        String intRegex = "[+-]?[0-9]+";
        String decimalRegex = "[+-]?([0-9]*\\.[0-9]+|[0-9]+\\.[0-9]*)";
        String numberRegex = "^"
                + blankRegex
                + "(" + intRegex + "|" + decimalRegex + ")"
                + "([Ee]" + intRegex + ")?"
                + blankRegex
                + "$";

        return s.matches(numberRegex);
    }

    public static void main(String[] args) {
        // 1.有限状态机
        // todo
        // 2.正则表达式
        System.out.println(new O0020().isNumber("0"));
        System.out.println(new O0020().isNumber("-1."));
        System.out.println(new O0020().isNumber("+100"));
        System.out.println(new O0020().isNumber("5e2"));
        System.out.println(new O0020().isNumber("-123"));
        System.out.println(new O0020().isNumber("-3.14155"));
        System.out.println(new O0020().isNumber("-1E-16"));
        System.out.println(new O0020().isNumber("0123"));
        System.out.println(new O0020().isNumber(".0123"));
        System.out.println(new O0020().isNumber("12e"));
        System.out.println(new O0020().isNumber("1a3.14"));
        System.out.println(new O0020().isNumber("1.2.3"));
        System.out.println(new O0020().isNumber("+-5"));
        System.out.println(new O0020().isNumber("12e+5.4"));
        System.out.println(new O0020().isNumber("."));
        System.out.println(new O0020().isNumber("e"));
        System.out.println(new O0020().isNumber("1.2.3.45"));
        System.out.println(new O0020().isNumber("       "));
    }

}
