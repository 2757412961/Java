package edu.zju.zjh.core.network.socket;

import java.net.InetSocketAddress;

/**
 * @author: zjh
 * @date : 2022/7/13 10:26
 * @Email : 2757412961@qq.com
 * @update:
 */

public class TestInetSocketAddress {

    public static void main(String[] args) {
        InetSocketAddress address1 = new InetSocketAddress("127.0.0.1", 8080);
        System.out.println(address1);
        InetSocketAddress address2 = new InetSocketAddress("localhost", 8080);
        System.out.println(address2);
        System.out.println(address1.getAddress());
        System.out.println(address1.getHostName());
        System.out.println(address1.getPort());
    }

}
