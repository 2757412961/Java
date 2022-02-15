package edu.zju.zjh.gof23.bridge;

/**
 * @author: zjh
 * @date : 2021/4/1 19:11
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Test {

    public static void main(String[] args) {
        // apple
        Laptop laptop = new Laptop(new Apple());
        laptop.info();
        // lenovo
        Desktop desktop = new Desktop(new Lenovo());
        desktop.info();

    }

}
