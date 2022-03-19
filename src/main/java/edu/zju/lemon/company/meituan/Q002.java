package edu.zju.lemon.company.meituan;

import java.util.Scanner;

/**
 * @author: zjh
 * @date : 2022/3/19 上午 10:57
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q002 {

    /**
     * 6 1
     * hhhaaa
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int type = in.nextInt();
        in.nextLine(); // 关键 要换行了
        String str = in.nextLine();
        StringBuilder s = new StringBuilder(str);
        StringBuilder t = new StringBuilder();

        int idx = -1;
        if (type == 1) {
            while (s.length() > 0) {
                idx = (s.length() - 1) / 2;
                t.append(s.charAt(idx));
                s.deleteCharAt(idx);
            }
        } else if (type == 2) {
            for (int i = n - 1; i >= 0; i--) {
                idx = t.length() / 2;
                t.insert(idx, s.charAt(i));
            }
        }

        System.out.println(t.toString());
    }

}
