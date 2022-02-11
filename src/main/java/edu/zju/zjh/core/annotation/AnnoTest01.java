package main.java.edu.zju.zjh.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: zjh
 * @date : 2021/4/7 18:56
 * @Email : 2757412961@qq.com
 * @update:
 */

public class AnnoTest01 {
    //注解可以显示赋值，如果没有默认值 ，我们就必须给注解赋值
    @MyAnnotation01(schools = {"dz", "sj"})
    public void test() {

    }

    // 只有 value 可以省略 [value =] 1234
    @MyAnnotation02(1234)
    public void test02() {

    }

}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation01 {
    // 注解的参数: 参数类型+参数名();
    String name() default "";

    int age() default 0;

    int id() default -1;

    String[] schools();
}

@interface MyAnnotation02 {
    int value();
}
