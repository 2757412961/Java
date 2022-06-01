package edu.zju.zjh.lc.string;

/**
 * @author: zjh
 * @date : 2022/6/1 9:48
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0415 {

    /**
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:41.5 MB,击败了29.72% 的Java用户
     */
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 && j >= 0) {
            int sum = carry + num1.charAt(i--) - '0' + num2.charAt(j--) - '0';
            sb.append(sum % 10);
            carry = sum / 10;
        }
        while (i >= 0) {
            int sum = carry + num1.charAt(i--) - '0';
            sb.append(sum % 10);
            carry = sum / 10;
        }
        while (j >= 0) {
            int sum = carry + num2.charAt(j--) - '0';
            sb.append(sum % 10);
            carry = sum / 10;
        }

        if (carry > 0) sb.append(carry);

        return sb.reverse().toString();
    }

}
