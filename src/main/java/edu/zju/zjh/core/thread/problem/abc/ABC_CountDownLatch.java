package edu.zju.zjh.core.thread.problem.abc;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;

/**
 * @author: zjh
 * @date : 2022/6/13 14:29
 * @Email : 2757412961@qq.com
 * @update:
 */

public class ABC_CountDownLatch {

    public static CountDownLatch cdl1 = new CountDownLatch(1);
    public static CountDownLatch cdl2 = new CountDownLatch(1);

    static class ThreadA extends Thread {
        @Override
        public void run() {
            cdl1.countDown();
            System.out.println("A");
        }
    }

    static class ThreadB extends Thread {
        @SneakyThrows
        @Override
        public void run() {
            cdl1.await();
            System.out.println("B");
            cdl2.countDown();
        }
    }

    static class ThreadC extends Thread {
        @SneakyThrows
        @Override
        public void run() {
            cdl2.await();
            System.out.println("C");
        }
    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadC().start();
        new ThreadB().start();
    }

}
