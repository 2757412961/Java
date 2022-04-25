package edu.zju.zjh.lc.offer;

/**
 * @author: zjh
 * @date : 2022/4/25 10:13
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0065 {

    public int add(int a, int b) {
        while (b != 0) {
            int c = a & b;
            a = a ^ b;
            b = c << 1;
        }

        return a;
    }

}
