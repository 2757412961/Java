package edu.zju.zjh.core.jvm.oom;

/**
 * @author: zjh
 * @date : 2022/5/5 20:58
 * @Email : 2757412961@qq.com
 * @update:
 */

// -Xss128k
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Exception e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }

}
