package edu.zju.zjh.core.thread.proAndCon.lock;

import lombok.SneakyThrows;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: zjh
 * @date : 2022/4/27 11:59
 * @Email : 2757412961@qq.com
 * @update:
 */

public class ProConDemo {

    public static ReentrantLock lock = new ReentrantLock();
    public static volatile boolean flag;

    @SneakyThrows
    public static void main(String[] args) {
        Condition condition = lock.newCondition();
        Consumer consumer = new Consumer(lock, condition);
        Producer producer = new Producer(lock, condition);

        // ...
        Thread threadC = new Thread(consumer);
        Thread threadP = new Thread(producer);
        threadC.start();
        threadP.start();

        System.out.println();
        Thread.sleep(100);
        threadC.interrupt();
        threadP.interrupt();
    }

}
