package edu.zju.zjh.core.generic.type;

/**
 * @author: zjh
 * @date : 2022/6/8 10:14
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Cat extends Animal {

    @Override
    public void move() {
        System.out.println("Cat run");
    }

    public void miao() {
        System.out.println("Miao Miao");
    }

}
