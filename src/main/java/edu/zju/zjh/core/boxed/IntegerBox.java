package edu.zju.zjh.core.boxed;

/**
 * @author: zjh
 * @date : 2022/3/4 17:41
 * @Email : 2757412961@qq.com
 * @update:
 */

public class IntegerBox {

    public static void main(String[] args) {
        Integer a = 12345;
        Integer b = 12345;
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(a == 12345);

        System.out.println();
        Integer c = 1;
        Integer d = 1;
        System.out.println(c == d);
        System.out.println(c == 1);
        System.out.println(1234 == 1234);
    }

}
