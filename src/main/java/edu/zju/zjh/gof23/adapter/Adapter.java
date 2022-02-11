package main.java.edu.zju.zjh.gof23.adapter;

/**
 * @author: zjh
 * @date : 2021/4/1 16:37
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Adapter extends Adaptee implements NetToUsb {

    @Override
    public void handleRequest() {
        super.request();
    }

}
