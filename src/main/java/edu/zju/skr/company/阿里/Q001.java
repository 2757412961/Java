package edu.zju.skr.company.阿里;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author: zjh
 * @date : 2022/4/7 下午 06:52
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q001 {

    public int tras(char ch) {
        if ('0' <= ch && ch <= '9') {
            return ch - '0';
        } else {
            return ch - 'A' + 10;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int maxJZ = 1;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ('0' <= ch && ch <= '9') {
                maxJZ = Math.max(maxJZ, ch - '0');
            } else {
                maxJZ = Math.max(maxJZ, ch - 'A' + 10);
            }
        }

        for (int i = maxJZ + 1; i <= 16; i++) {
            System.out.println(new BigInteger(str, i).mod(new BigInteger("1000000007")));
        }
    }


}
