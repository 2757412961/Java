package edu.zju.zjh.core.thread;

import lombok.SneakyThrows;

import java.net.ServerSocket;

/**
 * @author: zjh
 * @date : 2022/4/20 9:26
 * @Email : 2757412961@qq.com
 * @update:
 */

public class ThreadInteruptExit {

    public static class ServerThread extends Thread {
        // volatile修饰符用来保证其它线程读取的总是该变量的最新的值
        public volatile boolean exit = false;

        @Override
        public void run() {
            while (!exit) {
                System.out.println("Running");
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public static class ThreadInterrupt implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName() + "---" + Thread.currentThread().isInterrupted());
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().isInterrupted());
                    break;
                }
            }
        }
    }

    public static class ThreadInterrupt2 extends Thread  {
        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName() + "---" + Thread.currentThread().isInterrupted());
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().isInterrupted());
                    break;
                }
            }
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        /**
         * 标记位 退出
         */
        System.out.println("================= 标记位 退出 ===============");
        ServerThread t = new ServerThread();
        t.start();

        Thread.sleep(500);
        t.exit = true; //修改标志位，退出线程
        System.out.println("exist");

        /**
         * Interrupte 退出
         * 两个与线程中断有关的方法:
         *   public boolean Thread.isInterrupted() //判断是否被中断
         *   public static boolean Thread.interrupted() //判断是否被中断，并清除当前中断状态
         * 终止线程的第三种方式：利用Thread类提供的interrupt()和InterruptedException。
         * 终止线程的第四种方式：利用Thread类提供的interrupt()和isInterrupted()。
         */
        System.out.println("================= Interrupte 退出 ===============");
        ThreadInterrupt interrupt = new ThreadInterrupt();
        Thread interruptThread = new Thread(interrupt, "interrupt");
        interruptThread.start();

        Thread.sleep(2);
        interruptThread.interrupt();
        Thread.sleep(100);
    }

}
