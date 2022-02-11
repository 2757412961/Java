package main.java.edu.zju.zjh.core.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author: zjh
 * @date : 2021/4/7 19:15
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Reflection {
    public static void get() throws NoSuchMethodException {
        User user = new User();
        Class<? extends User> clazz = user.getClass();
        System.out.println("========== 获得类的属性 ==========");
        System.out.println(clazz.getName());
        Field[] fields = clazz.getFields(); // 获取 public 的属性
        Field[] declaredFields = clazz.getDeclaredFields(); // 获取声明的属性
        System.out.println(Arrays.toString(fields));
        System.out.println(Arrays.toString(declaredFields));

        System.out.println("========== 获得类的方法 ==========");
        Method[] methods = clazz.getMethods(); // 获取 public 的方法，包括继承的对象
        Method[] declaredMethods = clazz.getDeclaredMethods(); // 获取声明的方法
        for (Method method : methods) {
            System.out.println("公开的：" + method);
        }
        for (Method method : declaredMethods) {
            System.out.println(method);
        }

        // 需要添加方法的参数：重载时需要用
        clazz.getMethod("setName", String.class);

        System.out.println("========== 获得类的构造器 ==========");
        Constructor<?>[] constructors = clazz.getConstructors();
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("公开的：" + constructor);
        }
        for (Constructor constructor : declaredConstructors) {
            System.out.println(constructor);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<?> c1 = Class.forName("com.zjh.annotation.reflection.User");
        Class<?> c2 = Class.forName("com.zjh.annotation.reflection.User");
        Class<?> c3 = Class.forName("com.zjh.annotation.reflection.User");

        System.out.println(c1);
        // class 对象只有一个
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());

        // 了解 class 能获取到什么
//        get();

        Class<User> clazz = User.class;
        System.out.println("========== 创建对象 ==========");
        Constructor<? extends User> constructor = clazz.getConstructor(int.class, String.class, int.class);
        User hello = constructor.newInstance(2, "hello", 213);
        System.out.println(hello);

        System.out.println("========== 调用方法 ==========");
        User user = clazz.newInstance();
        Method setName = clazz.getMethod("setName", String.class);
        setName.invoke(user, "user");
        System.out.println(user);

        System.out.println("========== 调用私有属性 ==========");
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true); // 启用私有变量的访问权限
        System.out.println(name.get(user));

    }
}



