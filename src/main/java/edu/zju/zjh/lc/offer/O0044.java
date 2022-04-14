package edu.zju.zjh.lc.offer;

/**
 * @author: zjh
 * @date : 2022/4/14 下午 02:41
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0044 {

    public int findNthDigit(int n) {
        if (n == 0) return 0;
        int digit = 1, count = 9, start = 1;

        n--;
        while (n > ((long) digit) * count) {
            n -= digit * count;
            digit++;
            count *= 10;
            start *= 10;
        }

        int num = n / digit;
        int i = n % digit;
        String str = String.valueOf(start + num);

        return str.charAt(i) - '0';
    }

    public static void main(String[] args) {
        System.out.println(new O0044().findNthDigit(2000000000));
    }

}
