package edu.zju.zjh.core.innerclass;

/**
 * @author: zjh
 * @date : 2022/5/31 9:12
 * @Email : 2757412961@qq.com
 * @update:
 */

/**
 * 内部类可以分为四种：
 * 1.实例内部类：直接定义在类当中的一个类，在类前面没有任何一个修饰符
 * 2.静态内部类：在内部类前面加上一个static
 * 3.局部内部类：定义在方法的内部类
 * 4.匿名内部类：属于局部内部的一种特殊情况
 */
class OuterClass {
    int x = 10;

    public class InnerClass {
        // 从内部类访问外部类成员
        int y = 5;
    }

    private class InnerClass2 {
        int y = 5;
    }

    protected class InnerClass3 {
        int y = 5;
    }

    // 注意：静态内部类无法访问外部类的成员。
    public static class InnerClass4 {
        int y = 5;
    }

    public static void main(String[] args) {
        OuterClass myOuter = new OuterClass();

        // public
        OuterClass.InnerClass myInner = myOuter.new InnerClass();
        System.out.println(myInner.y + myOuter.x);

        // private
        OuterClass.InnerClass myInner2 = myOuter.new InnerClass();

        // protect

    }

}
