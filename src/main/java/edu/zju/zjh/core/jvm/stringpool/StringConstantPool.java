package edu.zju.zjh.core.jvm.stringpool;

/**
 * @author: zjh
 * @date : 2022/5/23 14:38
 * @Email : 2757412961@qq.com
 * @update:
 */

public class StringConstantPool {

    /**
     * s1和s2中都指向常量池中的同一个内存空间，相等
     * 组成s3的子字符串均在常量池中；字符串拼接在编译期间会被优化，相等
     * 组成s4的子字符串通过创建新的对象而产生，运行时分配的内存空间未知，不相等
     * s7和s8虽然是字符串字面量，拼接成s9时，s7和s8是作为两个变量使用的，所在内存空间不可预料，不相等
     * s4和s5都被存储在堆中，地址不同，不相等
     * s6通过intern()方法，将字符串“hello”添加进常量池，而常量池中已经存在“hello”字符串，所以直接返回地址，所以s1和s6指向同一个地址，相等
     */
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = "hel" + "lo";
        String s4 = "hel" + new String("lo");
        String s5 = new String("hello");
        String s6 = s5.intern();
        String s7 = "h";
        String s8 = "ello";
        String s9 = s7 + s8;

        System.out.println(s1 == s2);   //true    (1)
        System.out.println(s1 == s3);   //true    (2)
        System.out.println(s1 == s4);   //false   (3)
        System.out.println(s1 == s9);   //false   (4)
        System.out.println(s4 == s5);   //false   (5)
        System.out.println(s1 == s6);   //true    (6)
    }

}
