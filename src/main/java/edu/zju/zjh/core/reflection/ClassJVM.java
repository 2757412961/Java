package main.java.edu.zju.zjh.core.reflection;

/**
 * @author: zjh
 * @date : 2021/4/7 20:55
 * @Email : 2757412961@qq.com
 * @update:
 */

public class ClassJVM {
    static {
        System.out.println("main");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("===== A =====");
        A a = new A();
        System.out.println(A.m);

        // 类的主动引用
        System.out.println("===== 类的主动引用 =====");
        // 1.当虚拟机启动，先初始化main方法所在的类

        // 2.new 一个类的对象
//        new Father();

        // 3.调用类的静态成员(除了final常量)和静态方法
//        int son = Son.son;

        // 4.使用java.lang.reflect包的方法对类进行反射调用
//        Class.forName("com.zjh.annotation.reflection.Son");

        // 5.当初始化一个类，如果其父类没有被初始化，则先会初始化它的父类
//        new Son();

        // 类的被动引用
        System.out.println("===== 类的被动引用 =====");
        // 1.当访问一个静态域时，只有真正声明这个域的类才会被初始化。如:当通过子类引用父类的静态变量，不会导致子类初始化
//        int father = Son.father;

        // 2.通过数组定义类引用，不会触发此类的初始化。因为数组底层被初始化为 null
        Son[] sons= new Son[3];

        // 3.引用常量不会触发此类的初始化(常量在链接阶段就存入调用类的常量池中了)
        int com = Son.com;
     }
}

class A {
    static {
        System.out.println("A类静态代码块初始化");
        m = 300;
    }

    static int m = 100;

    public A() {
        System.out.println("A类无参构造初始化");
    }
}

class Father {

    static {
        System.out.println("Father");
    }

    static int father = 312;

}

class Son extends Father {

    static {
        System.out.println("Son");
    }

    static int son = 12;

    static final int com = 123123;
}