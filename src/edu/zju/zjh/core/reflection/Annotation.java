package edu.zju.zjh.core.reflection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/**
 * @author: zjh
 * @date : 2021/4/8 9:50
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Annotation {
    public static void main(String[] args) throws NoSuchFieldException {
        Class<Man> clazz = Man.class;
        java.lang.annotation.Annotation[] declaredAnnotations = clazz.getDeclaredAnnotations();

        System.out.println("========== 获取类上的注解 ==========");
        for (java.lang.annotation.Annotation declaredAnnotation : declaredAnnotations) {
            System.out.println(declaredAnnotation);
        }
        System.out.println("========== 获取类上的注解的值 value ==========");
        ORM declaredAnnotation = clazz.getDeclaredAnnotation(ORM.class);
        System.out.println(declaredAnnotation.value());

        System.out.println("========== 获取类属性的注解 ==========");
        Field name = clazz.getDeclaredField("name");
        FieldA annotation = name.getAnnotation(FieldA.class);
        System.out.println(annotation);

        System.out.println("========== 获取类属性的注解的值 value ==========");
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface ORM {
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldA {
    String columnName();

    String type();

    int length();
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@ORM("db_man")
class Man {
    @FieldA(columnName = "id", type = "String", length = 36)
    private int id;

    @FieldA(columnName = "name", type = "String", length = 36)
    private String name;

    @FieldA(columnName = "age", type = "int", length = 10)
    private int age;

    private void test() {

    }
}