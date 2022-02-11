package main.java.edu.zju.zjh.gof23.adapter;

/**
 * @author: zjh
 * @date : 2021/4/1 16:47
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Adapter2 implements NetToUsb {

    private Adaptee adaptee;

    public Adapter2(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void handleRequest() {
        this.adaptee.request();
    }
}
