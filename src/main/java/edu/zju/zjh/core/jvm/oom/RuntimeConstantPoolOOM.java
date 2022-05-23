package edu.zju.zjh.core.jvm.oom;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: zjh
 * @date : 2022/5/5 21:05
 * @Email : 2757412961@qq.com
 * @update:
 */

// 运行时常量池溢出导致内存溢出 jdk7中
// 参数： -Xmx6M -XX:MaxMetaspaceSize=6M -XX:PermSize=6M
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        short i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }
    }

}
