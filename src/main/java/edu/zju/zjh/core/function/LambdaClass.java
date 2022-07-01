package edu.zju.zjh.core.function;

/**
 * @author: zjh
 * @date : 2022/7/1 10:31
 * @Email : 2757412961@qq.com
 * @update:
 */

public class LambdaClass {

    @FunctionalInterface
    public interface LambdaInterface {
        String f();
    }

    //函数式接口参数
    public static void lambdaInterfaceDemo(LambdaInterface i) {
        System.out.println(i.f());
    }

    public static void forEg() {
        lambdaInterfaceDemo(() -> "自定义函数式接口");
    }

    public static void main(String[] args) {
        LambdaClass.forEg();
    }

}

