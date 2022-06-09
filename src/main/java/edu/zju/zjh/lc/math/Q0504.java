package edu.zju.zjh.lc.math;

/**
 * @author: zjh
 * @date : 2022/6/9 11:23
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0504 {

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.4 MB,击败了7.89% 的Java用户
     */
    public String convertToBase7(int num) {
        StringBuilder res = new StringBuilder();
        String sign = "";
        if (num < 0) {
            sign = "-";
            num = -num;
        }

        do {
            res.append(num % 7);
            num /= 7;
        } while (num > 0);

        return res.append(sign).reverse().toString();
    }

}
