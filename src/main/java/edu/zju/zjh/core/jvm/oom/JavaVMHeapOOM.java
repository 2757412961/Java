package edu.zju.zjh.core.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zjh
 * @date : 2022/5/5 20:56
 * @Email : 2757412961@qq.com
 * @update:
 */

public class JavaVMHeapOOM {

    // -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }

}
