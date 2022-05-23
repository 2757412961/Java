package edu.zju.zjh.core.jvm.stringpool;

/**
 * @author: zjh
 * @date : 2022/5/23 14:38
 * @Email : 2757412961@qq.com
 * @update:
 */

public class StringConstantPool2 {

    /**
     * 	1.单独使用””引号创建的字符串都是常量,编译期就已经确定存储到Constant Pool中；
     * 	2.使用new String(“”)创建的对象会存储到heap中,是运行期新创建的；
     * 	3.使用只包含常量的字符串连接符如”aa” + “aa”创建的也是常量,编译期就能确定,已经确定存储到String Pool中,
     * 	  String pool中存有“aaaa”；但不会存有“aa”。
     * 	4.使用包含变量的字符串连接符如”aa” + s1创建的对象是运行期才创建的,存储在heap中；
     * 	  只要s1是变量，不论s1指向池中的字符串对象还是堆中的字符串对象，运行期”aa” + s1操作实际上是编译器创建了StringBuilder对象
     * 	  进行了append操作后通过toString()返回了一个字符串对象存在heap上。
     * 	5.*
     *  6.对于final String s2 = “111”。s2是一个用final修饰的变量，在编译期已知，在运行s2+”aa”时直接用常量“111”来代替s2。
     *   所以s2+”aa”等效于“111”+ “aa”。在编译期就已经生成的字符串对象“111aa”存放在常量池中。
     */
    public static void main(String[] args) {
        String m = "hello,world";
        // 会分配一个11长度的char数组，并在常量池分配一个由这个char数组组成的字符串，然后由m去引用这个字符串
        String n = "hello,world";
        // 用n去引用常量池里边的字符串，所以和m引用的是同一个对象
        String u = new String(m);
        // 生成一个新的字符串，但内部的字符数组引用着m内部的字符数组
        String v = new String("hello,world");
        // 同样会生成一个新的字符串，但内部的字符数组引用常量池里边的字符串内部的字符数组，意思是和u是同样的字符数组

        // test
        System.out.println(m == n); // true
        System.out.println(m == u); // false
        System.out.println(m == v); // false
        System.out.println(u == v); // false

        System.out.println(m == u.intern()); // true
        System.out.println(m == v.intern()); // true
        System.out.println(n == v.intern()); // true
        System.out.println(u.intern() == v.intern()); // true
    }

}
