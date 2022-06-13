package edu.zju.zjh.lc.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: zjh
 * @date : 2022/6/11 13:48
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q1114 {

    /**
     * 执行耗时:10 ms,击败了29.67% 的Java用户
     * 内存消耗:40.4 MB,击败了65.38% 的Java用户
     */
    static class Foo {

        public static int count = 0;
        public static ReentrantLock relock = new ReentrantLock();

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            int tryTime = 0;
            while (tryTime == 0) {
                while (count % 3 == 0) {
                    relock.lock();
                    try {
                        // printFirst.run() outputs "first". Do not change or remove this line.
                        printFirst.run();
                        count++;
                        tryTime++;
                    } finally {
                        relock.unlock();
                    }
                }
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            int tryTime = 0;
            while (tryTime == 0) {
                while (count % 3 == 1) {
                    relock.lock();
                    try {
                        // printSecond.run() outputs "second". Do not change or remove this line.
                        printSecond.run();
                        count++;
                        tryTime++;
                    } finally {
                        relock.unlock();
                    }
                }
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            int tryTime = 0;
            while (tryTime == 0) {
                while (count % 3 == 2) {
                    relock.lock();
                    try {
                        // printThird.run() outputs "third". Do not change or remove this line.
                        printThird.run();
                        count++;
                        tryTime++;
                    } finally {
                        relock.unlock();
                    }
                }
            }
        }

    }

}
