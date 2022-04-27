package edu.zju.zjh.core.thread.proAndCon.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: zjh
 * @date : 2022/4/27 11:57
 * @Email : 2757412961@qq.com
 * @update:
 */

class Consumer implements Runnable {

    private ReentrantLock lock;

    private Condition condition;

    public Consumer(ReentrantLock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {

        try {
            while (!Thread.interrupted()) {
                lock.lock();
                try {
                    while (!ProConDemo.flag) {
                        condition.await();
                    }
                    System.out.println(Thread.currentThread() + " consumer shout !!!!");
                    ProConDemo.flag = false;
                    condition.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



