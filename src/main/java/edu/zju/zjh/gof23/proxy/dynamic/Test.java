package main.java.edu.zju.zjh.gof23.proxy.dynamic;

/**
 * @author: zjh
 * @date : 2021/4/1 20:22
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Test {
    public static void main(String[] args) {
        Host host = new Host();

        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();
        proxyInvocationHandler.setRent(host);

        Rent rentProxy = (Rent) proxyInvocationHandler.getProxy();
        rentProxy.rent();
    }
}
