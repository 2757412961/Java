package edu.zju.zjh.lc.array;

import java.util.Arrays;

/**
 * @author: zjh
 * @date : 2022/5/30 10:07
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0066 {

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.5 MB,击败了89.48% 的Java用户
     */
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int sum = 0, carry = 1;

        // 自后往前加
        for (int i = n - 1; i >= 0; i--) {
            sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }

        // 进位的特殊情况
        if (carry > 0) {
            final int[] newDigit = new int[n + 1];
            newDigit[0] = carry;
            for (int i = 0; i < digits.length; i++) {
                newDigit[i + 1] = digits[i];
            }
            return newDigit;
        }

        return digits;
    }

    /**
     * 方法一：找出最长的后缀 9
     */

}
