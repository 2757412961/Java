package main.java.edu.zju.zjh.gof23.proxy.init;

/**
 * @author: zjh
 * @date : 2021/4/1 19:44
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Proxy implements Rent {

    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        host.rent();
    }

    public void seeHouse() {
        System.out.println("seeHouse");
    }

    public void fare() {
        System.out.println("fare");
    }

}
