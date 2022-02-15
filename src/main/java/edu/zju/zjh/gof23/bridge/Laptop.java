package edu.zju.zjh.gof23.bridge;

/**
 * @author: zjh
 * @date : 2021/4/1 19:15
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Laptop extends Computer {

    protected Laptop(Brand brand) {
        super(brand);
    }

    @Override
    public void info() {
        super.info();
        System.out.println(" Laptop");
    }
}
