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
        String str = "5 167 226 232 235 242 279 377 392 413 516 518 583 653 700 701 714 724 876 931 1014 1143";

        String[] strs = str.split("\\s+");
        Arrays.sort(strs, (a, b) -> Integer.valueOf(a) - Integer.valueOf(b));

        for (String s : strs) {
            System.out.print(s + " ");
        }
    }

    /**
     * 测试负数整除
     */
    @Test
    public void testDivide() {
        System.out.println(4 / (-3));
        System.out.println(Math.floorMod(4, -3));
        System.out.println(5 / (-3));
        System.out.println(Math.floorMod(5, -3));
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
