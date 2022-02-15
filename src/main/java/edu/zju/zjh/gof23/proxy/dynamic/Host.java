package edu.zju.zjh.gof23.proxy.dynamic;

/**
 * @author: zjh
 * @date : 2021/4/1 19:43
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Host implements Rent {

    @Override
    public void rent() {
        System.out.println("rent host house");
    }
}
