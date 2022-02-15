package edu.zju.zjh.gof23.builder.buliderThis;

public class Test {

    // 建造者模式
    public static void main(String[] args) {
        Builder worker = new Worker();

        // 链式编程
        Product product = worker
                .buildB("甜筒")
                .buildD("可乐")
                .getProduct();

        System.out.println(product.toString());
    }

}
