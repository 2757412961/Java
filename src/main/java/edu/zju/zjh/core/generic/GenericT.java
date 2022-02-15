package edu.zju.zjh.core.generic;

import java.util.List;

/**
 * @author: zjh
 * @date : 2021/7/29 上午 09:31
 * @Email : 2757412961@qq.com
 * @update:
 */

public class GenericT<T> {

    private List<T> list;

    private T element;

    public T get() {
        return element;
    }

    public static <P> P st(P p) {
        return p;
    }


}
