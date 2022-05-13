package edu.zju.zjh.core.thread.problem.abc;

/**
 * @author: zjh
 * @date : 2022/4/20 10:31
 * @Email : 2757412961@qq.com
 * @update:
 */

import lombok.SneakyThrows;

/**
 * 链接：https://www.jianshu.com/p/f79fa5aafb44
 * 题目：三线程按顺序交替打印ABC的四种方法
 * 描述：建立三个线程A、B、C，A线程打印10次字母A，B线程打印10次字母B,C线程打印10次字母C，
 * 但是要求三个线程同时运行，并且实现交替打印，即按照ABCABCABC的顺序打印。
 */
public class ABC_Synch {

    static class PrintThreadName implements Runnable {
        private String name;
        private Object prev;
        private Object self;

        public PrintThreadName(String name, Object prev, Object self) {
            this.name = name;
            this.prev = prev;
            this.self = self;
        }

        @Override
        public void run() {
            int count = 10;
            while (count > 0) {// 多线程并发，不能用if，必须使用whil循环
                synchronized (prev) { // 先获取 prev 锁
                    synchronized (self) {// 再获取 self 锁
                        System.out.print(name);//打印
                        count--;

                        self.notifyAll();// 唤醒其他线程竞争self锁，注意此时self锁并未立即释放。
                        // 不要在notify/notifyAll()后面再写一些耗时的代码。
                    }
                    //此时执行完self的同步块，这时self锁才释放。
                    try {
                        if (count == 0) {// 如果count==0,表示这是最后一次打印操作，通过notifyAll操作释放对象锁。
                            prev.notifyAll();
                        } else {
                            prev.wait(); // 立即释放 prev锁，当前线程休眠，等待唤醒
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        Object a = new Object(), b = new Object(), c = new Object();

        PrintThreadName pa = new PrintThreadName("A", c, a);
        PrintThreadName pb = new PrintThreadName("B", a, b);
        PrintThreadName pc = new PrintThreadName("C", b, c);

        new Thread(pa).start();
        Thread.sleep(10);
        new Thread(pb).start();
        Thread.sleep(10);
        new Thread(pc).start();
        Thread.sleep(10);

    }

}
