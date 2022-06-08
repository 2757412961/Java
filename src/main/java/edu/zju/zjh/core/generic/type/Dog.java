package edu.zju.zjh.core.generic.type;

/**
 * @author: zjh
 * @date : 2022/6/8 10:14
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Dog extends Animal {

    @Override
    public void move() {
        System.out.println("Dog run");
    }

    public void bark() {
        System.out.println("Bark");
    }

}
