package edu.zju.zjh.core.extend;

/**
 * @author: zjh
 * @date : 2022/7/6 8:59
 * @Email : 2757412961@qq.com
 * @update:
 */

public class StaticExtend {

    public static class Father {
        protected static String string = "abc";

        protected static void methond1() {
            System.out.println("father method1");
        }
    }


    public static class Son extends Father {
        //表明父类的静态属性和静态方法可以被子类继承
        public static void sonMethod() {
            System.out.println(string);

            methond1();
        }

        //表明静态方法不能被子类重写
        // @Override
        // java: 方法不会覆盖或实现超类型的方法
        protected static void methond1() {
            System.out.println("son method1");
        }

        private void doSomething() {
            // 不应该通过类实例访问静态成员
            super.string = "abcd";
            System.out.println(string);
        }

        public static void main(String[] args) {
            Father father = new Father();
            Father son = new Son(); //多态
            Son son1 = new Son();

            // 不应该通过类实例访问静态成员
            father.methond1();
            // father method1
            son.methond1();
            // father method1
            son1.methond1();
            // son method1

            son1.doSomething();
            // abcd
            Father.methond1();
            // father method1
        }
    }

}