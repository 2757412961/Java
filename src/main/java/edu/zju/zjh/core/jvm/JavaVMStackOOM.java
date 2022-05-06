package edu.zju.zjh.core.jvm;

/**
 * @author: zjh
 * @date : 2022/5/5 21:01
 * @Email : 2757412961@qq.com
 * @update:
 */

// -Xss2M  设置每个线程的堆栈大小
public class JavaVMStackOOM {

    private void dontStop() {

    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }

}
