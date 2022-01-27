package edu.zju.zjh.core.reflection;

import java.lang.reflect.Field;

/**
 * @author: zjh
 * @date : 2021/4/8 9:27
 * @Email : 2757412961@qq.com
 * @update:
 */

public class PerformanceAnalysis {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        User user = new User(489648, "asd a", 1231);
        Field name = user.getClass().getDeclaredField("name");
        name.setAccessible(true);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            user.getName();
        }
        long end = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            name.get(user);
        }
        long end2 = System.currentTimeMillis();

        // 反射和直接调用所花费的时间
        System.out.println("user.getName(): " + (end - start));
        System.out.println("user.getName(): " + (end2 - start2));

    }
}
