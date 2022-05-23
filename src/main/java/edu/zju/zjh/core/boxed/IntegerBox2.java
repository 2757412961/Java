package edu.zju.zjh.core.boxed;

/**
 * @author: zjh
 * @date : 2022/3/4 17:41
 * @Email : 2757412961@qq.com
 * @update:
 */

public class IntegerBox2 {

    public static void main(String[] args) {
        Integer i1 = 10;//this is autoboxing
        Integer i2 = 10;
        Integer i3 = 20;
        Integer i4 = new Integer(10);
        Integer i5 = new Integer(10);
        Integer i6 = new Integer(20);

        System.out.println(i1 == i2);       //true    (1)
        System.out.println(i3 == i1 + i2);  //true    (2)
        System.out.println(i1 == i4);       //false   (3)
        System.out.println(i4 == i5);       //false   (4)
        // “+”操作符不适用于Integer对象，首先i4和i5先进行自动拆箱操作，得到40，然后i6也进行自动拆箱为int值40，相等。
        System.out.println(i6 == i4 + i5);  //true    (5)
        System.out.println(20 == i4 + i5);  //true    (6)
    }

}
