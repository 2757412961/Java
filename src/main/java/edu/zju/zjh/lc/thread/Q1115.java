package edu.zju.zjh.lc.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: zjh
 * @date : 2022/6/13 19:15
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q1115 {

    /**
     * 1. Semaphore 适合控制顺序
     * 执行耗时:18 ms,击败了53.55% 的Java用户
     * 内存消耗:41.3 MB,击败了37.71% 的Java用户
     */
    private class S1 {

        class FooBar {

            private int n;
            private Semaphore sf = new Semaphore(1);
            private Semaphore sb = new Semaphore(0);

            public FooBar(int n) {
                this.n = n;
            }

            public void foo(Runnable printFoo) throws InterruptedException {
                for (int i = 0; i < n; i++) {
                    sf.acquire();
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    sb.release();
                }
            }

            public void bar(Runnable printBar) throws InterruptedException {
                for (int i = 0; i < n; i++) {
                    sb.acquire();
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    sf.release();
                }
            }

        }

    }

    /**
     * 2. 可重入锁 + Condition
     * 行耗时:16 ms,击败了99.39% 的Java用户
     * 内存消耗:40.9 MB,击败了93.27% 的Java用户
     */
    private class S2 {

        class FooBar {

            private int n;
            int count = 0;
            private ReentrantLock relock = new ReentrantLock();
            private Condition condition = relock.newCondition();

            public FooBar(int n) {
                this.n = n;
            }

            public void foo(Runnable printFoo) throws InterruptedException {
                for (int i = 0; i < n; i++) {
                    relock.lock();
                    try {
                        while (count % 2 != 0) {
                            condition.await();
                        }
                        count++;
                        // printFoo.run() outputs "foo". Do not change or remove this line.
                        printFoo.run();
                        condition.signalAll();
                    } finally {
                        relock.unlock();
                    }
                }
            }

            public void bar(Runnable printBar) throws InterruptedException {
                for (int i = 0; i < n; i++) {
                    relock.lock();
                    try {
                        while (count % 2 == 0) {
                            condition.await();
                        }
                        count++;
                        // printBar.run() outputs "bar". Do not change or remove this line.
                        printBar.run();
                        condition.signalAll();
                    } finally {
                        relock.unlock();
                    }
                }
            }

        }

    }

    /**
     * synchronized + 标志位 + 唤醒
     */

}
