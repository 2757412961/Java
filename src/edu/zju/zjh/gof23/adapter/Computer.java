package edu.zju.zjh.gof23.adapter;

/**
 * @author: zjh
 * @date : 2021/4/1 16:35
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Computer {

    public void net(NetToUsb adapter) {
        adapter.handleRequest();
    }


    public static void main(String[] args) {
        Computer computer = new Computer();
        Adaptee adaptee = new Adaptee();
        NetToUsb adapter = new Adapter();
        NetToUsb adapter2 = new Adapter2(adaptee);

        computer.net(adapter2);

    }

}








