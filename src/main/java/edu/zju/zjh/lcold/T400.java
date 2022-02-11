package main.java.edu.zju.zjh.lcold;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/8/27 上午 10:54
 * @Modified_By :
 */
public class T400 {
    public int findNthDigit_violence(int n) {
        String res = "";

        for (int i = 1; i <= n; i++) {
            res += i;
        }

        return res.charAt(n - 1) - '0';
    }

    public int findNthDigit(int n) {
        int ord = 1;
        long con = 9;

        while (true) {
            if (n > con * ord) {
                n -= con * ord;
                ord++;
                con *= 10;
            } else {
                n -= 1;
                int base =(int) Math.pow(10, ord - 1);
                int num = n / ord;
                int pos = n % ord;

                return String.valueOf(base + num).charAt(pos) - '0';
            }
        }
    }

    public static void main(String[] args) {
//        400. 第N个数字
//        在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
//
//        注意:
//        n 是正数且在32位整数范围内 ( n < 231)。
//
//        示例 1:
//        输入:
//        3
//        输出:
//        3
//
//        示例 2:
//        输入:
//        11
//        输出:
//        0
//
//        说明:
//        第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分。

//        int n = 3;
//        int n = 11;
        int n = 1000000000;

        System.out.println(new T400().findNthDigit(n));
        System.out.println(new T400().findNthDigit_violence(n));
    }
}
