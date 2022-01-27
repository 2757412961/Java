package edu.zju.zjh.core.reflection;

/**
 * @author: zjh
 * @date : 2021/4/7 21:28
 * @Email : 2757412961@qq.com
 * @update:
 */

public class ClassLoaderZ {

    public static void main(String[] args) throws ClassNotFoundException {
        // 获取用户类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        // 获取系统类加载器的父类加载器-->扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        // 获取扩展类加载器的父类加载器-->根加载器(C/c++)
        // 引导类加载器，rt加载器，显示不了
        ClassLoader parentFurther = parent.getParent();
        System.out.println(parentFurther);

        // 当前类的加载器
        ClassLoader classLoader = Class.forName("com.zjh.annotation.reflection.ClassLoaderZ").getClassLoader();
        System.out.println(classLoader);

//        System.out.println(System.getProperty("java.class.path"));

    }
}
