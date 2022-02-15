package edu.zju.zjh.core.reflection;

import lombok.Data;

import java.lang.annotation.ElementType;

/**
 * @author: zjh
 * @date : 2021/4/7 19:44
 * @Email : 2757412961@qq.com
 * @update:
 */

public class CreateClass {
    public static void main(String[] args) throws ClassNotFoundException {
        Person student = new Student();

        // 三种方式
        // 1.
        Class<? extends Person> c1 = student.getClass();
        // 2.
        Class<?> c2 = Class.forName("com.zjh.annotation.reflection.Student");
        // 3.
        Class<Student> c3 = Student.class;

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c1.getSuperclass());

        // 哪些类型可以有class对象
        System.out.println("===== 哪些类型可以有class对象 =====");
        Class<Object> c01 = Object.class;
        Class<Comparable> c02 = Comparable.class;
        Class<String[]> c03 = String[].class;
        Class<int[][]> c04 = int[][].class;
        Class<Override> c05 = Override.class;
        Class<ElementType> c06 = ElementType.class;
        Class<Void> c07 = void.class;
        Class<Class> c08 = Class.class;

        System.out.println(c01.hashCode());
        System.out.println(c02.hashCode());
        System.out.println(c03.hashCode());
        System.out.println(c04.hashCode());
        System.out.println(c05.hashCode());
        System.out.println(c06.hashCode());
        System.out.println(c07.hashCode());
        System.out.println(c08.hashCode());
    }
}

@Data
class Person {
    private String name;
}

class Student extends Person {
    public Student() {
        this.setName("student");
    }
}