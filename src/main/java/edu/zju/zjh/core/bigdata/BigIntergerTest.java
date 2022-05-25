package edu.zju.zjh.core.bigdata;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author: zjh
 * @date : 2022/5/24 15:24
 * @Email : 2757412961@qq.com
 * @update:
 */

public class BigIntergerTest {

    /**
     * 基本类型int有32位，范围是：[-2147483648, 2147483647]（正负21亿多）
     * 基本类型long有64位，范围是：[-9223372036854775808, 9223372036854775807]
     * <p>
     * 虽然double可以表示更大的范围，但是却不是精确的整数。因此当需要使用到超出范围的整数时，就需要“大整形”。
     * Java 中的大整形类java.math.BigInteger没有范围限制，使用方法如下：
     */
    public static void main(String[] args) {
        //
        BigInteger zero = BigInteger.ZERO;
        BigInteger one = BigInteger.ONE;
        BigInteger ten = BigInteger.TEN;

        // BigInteger的创建：
        BigInteger bi1 = new BigInteger("123");
        BigInteger bi2 = BigInteger.valueOf(234L);
        // 控制台输出
        System.out.println(bi1);
        System.out.println(bi1.toString());          // 10进制
        System.out.println(bi1.toString(2));   // 2进制
        // 二进制位数
        int len = bi1.bitLength();


        // BigInteger的输入输出：
        // 控制台读入大整数
        Scanner scanner = new Scanner(System.in);
        // BigInteger bi3 = scanner.nextBigInteger();
        // BigInteger bi4 = new BigInteger(scanner.nextLine());

        // BigInteger的比较：
        boolean equals = bi1.equals(bi2);
        int cmp = bi1.compareTo(bi2);

        // BigInteger的运算：
        // 加
        BigInteger sum = bi1.add(bi2);
        // 减
        BigInteger sub = bi1.subtract(bi2);
        // 乘
        BigInteger mul = bi1.multiply(bi2);
        // 除
        BigInteger div = bi1.divide(bi2);
        // 取余
        BigInteger mod = bi1.remainder(bi2);
        // 除数与余数 result[0]是商，result[1]是余数
        BigInteger[] result = bi1.divideAndRemainder(bi2);
        // 幂
        BigInteger pow = bi1.pow(4);
        // 相反数
        BigInteger neg = bi1.negate();
        // 绝对值
        BigInteger abs = bi1.abs();
        // 最大公约数
        BigInteger gcd = bi1.gcd(bi2);

        // BigInteger转换为基本类型：
        // 其中，大整形超出相应基本类型时截断高位，超出浮点型的范围时为Infinity。xxxValueExact()方法则是抛出ArithmeticException异常。
        byte byteValue = bi1.byteValue();
        byte byteValueExact = bi1.byteValueExact();
        short shortValue = bi1.shortValue();
        short shortValueExact = bi1.shortValueExact();
        int intValue = bi1.intValue();
        int intValueExact = bi1.intValueExact();
        long longValue = bi1.longValue();
        long longValueExact = bi1.longValueExact();
        float floatValue = bi1.floatValue();
        double doubleValue = bi1.doubleValue();
    }

}
