package edu.zju.zjh.lcold;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/8/3 下午 04:57
 * @Modified_By :
 */
public class T415 {
    public String addStrings(String num1, String num2) {
        StringBuffer sb = new StringBuffer();
        int i1 = num1.length() - 1;
        int i2 = num2.length() - 1;
        int carry = 0;

        while (i1 >= 0 && i2 >= 0) {
            int n1 = num1.charAt(i1) - '0';
            int n2 = num2.charAt(i2) - '0';
            int sum = n1 + n2 + carry;

            sb.append(sum % 10);
            carry = sum / 10;

            i1--;
            i2--;
        }

        while (i1 >= 0) {
            int n1 = num1.charAt(i1) - '0';
            int sum = n1 + carry;

            sb.append(sum % 10);
            carry = sum / 10;

            i1--;
        }

        while (i2 >= 0) {
            int n2 = num2.charAt(i2) - '0';
            int sum = n2 + carry;

            sb.append(sum % 10);
            carry = sum / 10;

            i2--;
        }

        if (carry > 0) {
            sb.append(carry);
        }
        sb.reverse();

        return sb.toString();
    }

    public static void main(String[] args) {
//        给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
//
//        注意：
//
//        num1 和num2 的长度都小于 5100.
//        num1 和num2 都只包含数字 0-9.
//        num1 和num2 都不包含任何前导零。
//        你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。

        String num1 = "23";
        String num2 = "123";

        System.out.println(new T415().addStrings(num1, num2));
    }
}
