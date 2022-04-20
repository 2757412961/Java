package edu.zju.zjh.core.thread;

import lombok.SneakyThrows;

/**
 * @author: zjh
 * @date : 2022/4/20 11:00
 * @Email : 2757412961@qq.com
 * @update:
 */

/**
 * wait()和notify()不能随便调用，必须包含在synchronized语句中，它们都需要先获取目标对象的监视器。
 * 如果没有在synchronized语句中会报java.lang.IllegalMonitorStateException
 * <p>
 * 　　1）wait()、notify()和notifyAll()方法是本地方法，并且为final方法，无法被重写。
 * 　　2）调用某个对象的wait()方法能让当前线程阻塞，并且当前线程必须拥有此对象的monitor（即锁，或者叫管程）
 * 　　3）调用某个对象的notify()方法能够唤醒一个正在等待这个对象的monitor的线程，如果有多个线程都在等待这个对象的monitor，
 * 则只能唤醒其中一个线程；
 * 　　4）调用notifyAll()方法能够唤醒所有正在等待这个对象的monitor的线程；
 */
public class WaitNotify {

    static class WaitNotifyRun implements Runnable {

        public static final Object lock = new Object();
        public static int count = 5;

        @Override
        public void run() {
            System.out.println("Happy everyday" + Thread.currentThread().getName());
            synchronized (lock) {
                while (count > 0) {
                     try {
                         lock.notify();
                         System.out.println(Thread.currentThread().getName() + "获得锁，wait()后的代码继续运行：" + count);
                         lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("我被唤醒了！" + Thread.currentThread().getName());
                    count--;
                }
            }
        }

    }

    @SneakyThrows
    public static void main(String[] args) {
        WaitNotifyRun waitNotifyRun = new WaitNotifyRun();

        Thread threadA = new Thread(waitNotifyRun, "threadA");
        Thread threadB = new Thread(waitNotifyRun, "threadB");

        threadA.start();
        threadB.start();

        Thread.sleep(100);
    }

}
