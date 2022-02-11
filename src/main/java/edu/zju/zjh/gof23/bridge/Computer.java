package main.java.edu.zju.zjh.gof23.bridge;

/**
 * @author: zjh
 * @date : 2021/4/1 18:58
 * @Email : 2757412961@qq.com
 * @update:
 */

public abstract class Computer {

    protected Brand brand;

    protected Computer(Brand brand) {
        this.brand = brand;
    }

    public void info() {
        brand.info();
    }
}
