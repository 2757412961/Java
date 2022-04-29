package edu.zju.zjh.core.thread.threadlocal;

import java.lang.reflect.Field;

/**
 * @author: zjh
 * @date : 2022/4/28 10:48
 * @Email : 2757412961@qq.com
 * @update:
 */

/**
 * 问题， ThreadLocal 的key是弱引用，那么在ThreadLocal.get()的时候，发生GC之后，key是否是null？
 */
public class ThreadLocalGC {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InterruptedException {
        Thread t = new Thread(() -> test("abc", false));
        t.start();
        t.join();
        System.out.println("========== gc后 ===========");
        Thread t2 = new Thread(() -> test("def", true));
        t2.start();
        t2.join();
    }

    private static void test(String s, boolean isGC) {
        try {
            /**
             * 题目说的是在做 ThreadLocal.get() 操作，证明其实还是有强引用存在的，所以 key 并不为 null，
             * 如下图所示，ThreadLocal的强引用仍然是存在的。
             * 不会出现内存泄漏。
             */
            // ThreadLocal<String> threadLocal = new ThreadLocal<>();
            // threadLocal.set(s);
            /**
             * 这里创建的ThreadLocal并没有指向任何值，也就是没有任何引用
             * 如果我们的强引用不存在的话，那么 key 就会被回收，也就是会出现我们 value 没被回收，key 被回收，导致 value 永远存在，
             * 出现内存泄漏。
             */
            new ThreadLocal<>().set(s);
            if (isGC) {
                System.gc();
            }
            Thread t = Thread.currentThread();
            Class<? extends Thread> clz = t.getClass();
            Field field = clz.getDeclaredField("threadLocals");
            field.setAccessible(true);
            Object ThreadLocalMap = field.get(t);
            Class<?> tlmClass = ThreadLocalMap.getClass();
            Field tableField = tlmClass.getDeclaredField("table");
            tableField.setAccessible(true);
            Object[] arr = (Object[]) tableField.get(ThreadLocalMap);
            for (Object o : arr) {
                if (o != null) {
                    Class<?> entryClass = o.getClass();
                    Field valueField = entryClass.getDeclaredField("value");
                    Field referenceField = entryClass.getSuperclass().getSuperclass().getDeclaredField("referent");
                    valueField.setAccessible(true);
                    referenceField.setAccessible(true);
                    System.out.println(String.format("弱引用key:%s,值:%s", referenceField.get(o), valueField.get(o)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

