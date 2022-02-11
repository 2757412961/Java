package main.java.edu.zju.zjh.gof23.proxy.init;

/**
 * @author: zjh
 * @date : 2021/4/1 19:43
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Client {
    public static void main(String[] args) {
        Host host = new Host();
//        host.rent();

        Proxy proxy = new Proxy(host);
        proxy.rent();


    }
}
