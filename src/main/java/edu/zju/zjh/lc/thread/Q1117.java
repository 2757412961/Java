package edu.zju.zjh.lc.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: zjh
 * @date : 2022/6/18 13:54
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q1117 {

    /**
     * 方法1:Semaphore
     * 执行耗时:12 ms,击败了84.14% 的Java用户
     * 内存消耗:43.5 MB,击败了5.01% 的Java用户
     */
    private class S1 {

        class H2O {

            private Semaphore o = new Semaphore(2);
            private Semaphore h = new Semaphore(0);

            public H2O() {

            }

            public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
                h.acquire();
                // releaseHydrogen.run() outputs "H". Do not change or remove this line.
                releaseHydrogen.run();
                o.release();
            }

            public void oxygen(Runnable releaseOxygen) throws InterruptedException {
                o.acquire(2);
                // releaseOxygen.run() outputs "O". Do not change or remove this line.
                releaseOxygen.run();
                h.release(2);
            }

        }

    }

    /**
     * 方法2:Semaphore+CyclicBarrier
     */

    /**
     * 方法3:ReentrantLock+Condition
     * 执行耗时:13 ms,击败了39.07% 的Java用户
     * 内存消耗:41.9 MB,击败了90.57% 的Java用户
     */
    private class S3 {

        class H2O {

            private int state = 0;
            private ReentrantLock relock = new ReentrantLock();
            private Condition cond = relock.newCondition();

            public H2O() {

            }

            public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
                relock.lock();
                try {
                    while (state % 3 == 0) {
                        cond.await();
                    }
                    state++;
                    // releaseHydrogen.run() outputs "H". Do not change or remove this line.
                    releaseHydrogen.run();
                    cond.signalAll();
                } finally {
                    relock.unlock();
                }
            }

            public void oxygen(Runnable releaseOxygen) throws InterruptedException {
                relock.lock();
                try {
                    while (state % 3 != 0) {
                        cond.await();
                    }
                    state++;
                    // releaseOxygen.run() outputs "O". Do not change or remove this line.
                    releaseOxygen.run();
                    cond.signalAll();
                } finally {
                    relock.unlock();
                }
            }

        }

    }

    /**
     * 方法4:synchronized
     */

    /**
     * 方法5:BlockingQueue
     * 执行耗时:11 ms,击败了99.75% 的Java用户
     * 内存消耗:42.1 MB,击败了65.02% 的Java用户
     */
    private class S5 {

        class H2O {

            private int cnt = 0;
            private BlockingQueue<Integer> hQ = new LinkedBlockingDeque<>(2);
            private BlockingQueue<Integer> oQ = new LinkedBlockingDeque<>(1);

            public H2O() {

            }

            public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
                hQ.put(1);
                releaseHydrogen.run();
                cnt++;
                if (cnt == 3) {
                    cnt = 0;
                    hQ.clear();
                    oQ.clear();
                }
            }

            public void oxygen(Runnable releaseOxygen) throws InterruptedException {
                oQ.put(1);
                releaseOxygen.run();
                cnt++;
                if (cnt == 3) {
                    cnt = 0;
                    hQ.clear();
                    oQ.clear();
                }
            }
        }

    }

}
