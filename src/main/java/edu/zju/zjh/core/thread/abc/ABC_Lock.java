package edu.zju.zjh.core.thread.abc;

/**
 * @author: zjh
 * @date : 2022/4/20 10:31
 * @Email : 2757412961@qq.com
 * @update:
 */

import lombok.SneakyThrows;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 链接：https://www.jianshu.com/p/f79fa5aafb44
 * 题目：三线程按顺序交替打印ABC的四种方法
 * 描述：建立三个线程A、B、C，A线程打印10次字母A，B线程打印10次字母B,C线程打印10次字母C，
 * 但是要求三个线程同时运行，并且实现交替打印，即按照ABCABCABC的顺序打印。
 */
public class ABC_Lock {

    private static Lock lock = new ReentrantLock(); // 通过JDK5中的Lock锁来保证线程的访问的互斥
    private static int state = 0; //通过state的值来确定是否打印

    static class ThreadA extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    while (state % 3 == 0) { // 多线程并发，不能用if，必须用循环测试等待条件，避免虚假唤醒
                        System.out.print("A");
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock(); // unlock()操作必须放在finally块中
                }
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    while (state % 3 == 1) {
                        System.out.print("B");
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock(); // unlock()操作必须放在finally块中
                }
            }
        }
    }

    static class ThreadC extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    while (state % 3 == 2) {
                        System.out.print("C");
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock(); // unlock()操作必须放在finally块中
                }
            }
        }
    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }

}
