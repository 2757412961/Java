package edu.zju.zjh.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: zjh
 * @date : 2022/4/26 16:35
 * @Email : 2757412961@qq.com
 * @update:
 */

public class SomeThing {

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
     * 测试 Boolean
     */
    @Test
    public void testBoolean() {
        char c = 'a';
        c++;

        boolean b = false;
    }

}
