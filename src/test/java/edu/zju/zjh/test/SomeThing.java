package edu.zju.zjh.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * @author: zjh
 * @date : 2022/4/26 16:35
 * @Email : 2757412961@qq.com
 * @update:
 */

public class SomeThing {

    @Test
    public void test() {

    }

    @Test
    public void testSort() {
        // Offer II Done
        String str = "5 15 18 28 200 322 389 409 416 424 456 483 496 509 589 709 720 735 953 1232 1281 1309 1502 1572 1588 1672 1678 1768 1779 1790 1822";

        String[] strs = str.split("\\s+");
        Arrays.sort(strs, (a, b) -> Integer.valueOf(a) - Integer.valueOf(b));

        for (String s : strs) {
            System.out.print(s + " ");
        }
    }

    /**
     * Java中有关负数整除的计算
     * 除法的取整分为三类：向上取整、向下取整、向零取整。
     * <p>
     * 1.向上取整：向+∞方向取最接近精确值的整数。在这种取整方式下，5 / 3 = 2， -5 / -3 = 2， -5 / 3 = -1， 5 / -3 = -1
     * 2.向下取整：向-∞方向取最接近精确值的整数。在这种取整方式下，5 / 3 = 1， -5 / -3 = 1， -5 / 3 = -2， 5 / -3 = -2
     * 3.向零取整：向0方向取最接近精确值的整数，换言之就是舍去小数部分，因此又称截断取整。在这种取整方式下，5 / 3 = 1， -5 / -3 = 1， -5 / 3 = -1， 5 / -3 = -1
     * <p>
     * 通过观察可以发现，无论是向上取整还是向下取整，(-a)/b==-(a/b)都不一定成立。这给程序设计者带来了极大的麻烦。
     * 而对于向零取整，(-a)/b==-(a/b)是成立的，以此，C/C++（包括Java）采用这种取整方式。
     */
    @Test
    public void testDivide() {
        System.out.println(4 / (-3));
        System.out.println(5 / (-3));
        System.out.println(Math.floorDiv(4, -3));
        System.out.println(Math.floorDiv(5, -3));
    }

    /**
     * Java中有关负数取余的计算
     * 取余的计算，首先可以先不管被除数和除数的正负关系，全部都按照整数来计算，最后定符号。
     * 根据上面的打印结果可以看出结果的正负号规律为：取模的正负号与被除数同号
     */
    @Test
    public void testMod() {
        /**
         * 2 % 3 = 2
         * 2 % -3 = 2
         * -2 % 3 = -2
         * -2 % -3 = -2
         * 3 % 2 = 1
         * 3 % -2 = 1
         * -3 % 2 = -1
         * -3 % -2 = -1
         */
        System.out.println("2 % 3 = " + 2 % 3);
        System.out.println("2 % -3 = " + 2 % -3);
        System.out.println("-2 % 3 = " + -2 % 3);
        System.out.println("-2 % -3 = " + -2 % -3);
        System.out.println("3 % 2 = " + 3 % 2);
        System.out.println("3 % -2 = " + 3 % -2);
        System.out.println("-3 % 2 = " + -3 % 2);
        System.out.println("-3 % -2 = " + -3 % -2);
    }

    /**
     * 测试正则匹配点
     */
    @Test
    public void testRegex() {
        String[] split = "asddsaf.asdfas".split("\\.");
        for (String s : split) {
            System.out.println(s);
        }
    }

    /**
     * 测试正则匹配空格、json的空格
     */
    @Test
    public void testRegexBlank() {
        // no
        System.out.println(" (?=[^\"]*(\"[^\"]*\"[^\"]*)*$)");
        System.out.println("Mary had \"a little\"   \"lamb\"   \"a little lamb\"fh  fgh".replaceAll(
                " (?=[^\"]*(\"[^\"]*\"[^\"]*)*$)",
                "#"
        ));
        // no
        System.out.println(" (?![^()]*+\\))");
        System.out.println("Mary had (a , lie) lb(  ,(,a li ,lamb))fh  fgh".replaceAll(
                " (?![^()]*+\\))",
                "#"
        ));
        // yes something wrong
        System.out.println(" (?![^{}]*+\\})");
        System.out.println("sad {du asd} } fast {a=Select * From table, c = { {} {} }, fd = { } } wusd".replaceAll(
                " (?![^{}]*+\\})",
                "#"
        ));
        // test
        System.out.println();
        String[] split = "sad duck saf.asd fast {a=\"Select * From table\", c=, fd = } wusd".split(
                " (?![^{}]*+\\})"
        );
        for (String s : split) {
            System.out.println(s);
        }
    }

    /**
     * 测试 String Pool
     */
    @Test
    public void testStringConstantPool() {
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

    /**
     * 测试 StringBuilder
     */
    @Test
    public void testStringBuilder() {
        List<String> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("app1 ");
        System.out.println(sb.toString());
        list.add(sb.toString());
        sb.append("app2 ");
        System.out.println(sb.toString());
        list.add(sb.toString());

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    /**
     * 测试 StringBuilder reverse()
     */
    @Test
    public void testStringBuilderReverse() {
        StringBuilder sb = new StringBuilder();
        sb.append("test reverse");
        System.out.println(sb.toString());

        System.out.println(sb.reverse().toString());
        System.out.println(sb.toString());
        StringBuilder insert = sb.insert(0, "###");
        System.out.println(sb.toString());


        String s = "FY2D_FDI_ALL_NOM_20140423_0430.hdf";
        String rep = s.replace("hdf", "pdf");
        System.out.println(s);
        System.out.println(rep);
    }

    /**
     * 测试 Boolean
     */
    @Test
    public void testBoolean() {
        char c = 'a';
        c++;

        boolean b = false;
    }

    /**
     * 测试 Integer
     */
    @Test
    public void testInteger() {
        Integer max = Integer.MAX_VALUE;

        System.out.println(max++);
        System.out.println(max++);
        System.out.println(max++);
    }

    /**
     * 测试 String
     */
    @Test
    public void testString() {
        String s = "01234567890";

        System.out.println(s.startsWith("012"));
        System.out.println(s.startsWith("345"));
        System.out.println(s.startsWith("345", 2));
        System.out.println(s.startsWith("345", 3));
    }

    /**
     * 测试 Integer Radix
     */
    @Test
    public void testIntegerRadix() {
        System.out.println(Integer.toString(11, 2));
    }

    /**
     * 测试 Final
     */
    @Test
    public void testFinal() {
        final Integer finala;

        finala = 10;
        System.out.println(finala);
    }

    /**
     * 测试 SetRemove
     */
    @Test
    public void testSetRemove() {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);
        set.add(2);

        boolean remove1 = set.remove(1);
        boolean remove3 = set.remove(3);

        set.stream().forEach(System.out::println);
    }

    /**
     * 测试 Convert
     */
    @Test
    public void testConvert() {
        int a = 255;
        byte b = 127;

        System.out.println((byte) a);
        System.out.println((byte) a == b);
    }

    @Test
    public void testStack() {
        LinkedList<Integer> stack = new LinkedList<>();

        stack.push(1);
        System.out.println(stack.toString());

        stack.push(2);
        System.out.println(stack.toString());

        stack.push(3);
        System.out.println(stack.toString());

        System.out.println(stack.pop());
        System.out.println(stack.toString());

        System.out.println(stack.peek());
        System.out.println(stack.toString());

        System.out.println(stack.poll());
        System.out.println(stack.toString());
    }

    @Test
    public void testLamndaFor() {
        List<String> strings = Arrays.asList("1", "2", "3");
        //传统foreach
        for (String s : strings) {
            System.out.println(s);
        }
        //Lambda foreach
        strings.forEach((s) -> System.out.println(s));
        //or
        strings.forEach(System.out::println);
        //map
        Map<Integer, String> map = new HashMap<>();
        map.forEach((k, v) -> System.out.println(v));
    }


}
