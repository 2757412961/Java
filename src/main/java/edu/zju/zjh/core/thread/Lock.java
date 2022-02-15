package edu.zju.zjh.core.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: zjh
 * @date : 2021/8/20 上午 11:00
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Lock {

    public static void main(String[] args) {
        TestLock2 testLock = new TestLock2();

        new Thread(testLock, "A").start();
        new Thread(testLock, "B").start();
        new Thread(testLock, "C").start();
    }

}

class TestLock2 implements Runnable {
    int count = 100;

    //定义lock锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                // 进入加锁状态
                // 在不加锁的情况下，ABC可能会同时操作到count，导致数据紊乱
                //在加了锁之后，ABC排队操作
                lock.lock();
                if (count > 0) {
                    System.out.println(Thread.currentThread().getName() + "---" + count--);
                } else {
                    break;
                }
            } finally {
                // 解锁
                lock.unlock();
            }
        }
    }
}
