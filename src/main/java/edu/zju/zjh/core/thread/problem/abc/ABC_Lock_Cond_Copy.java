package edu.zju.zjh.core.thread.problem.abc;

/**
 * @author: zjh
 * @date : 2022/4/20 10:31
 * @Email : 2757412961@qq.com
 * @update:
 */

import lombok.NoArgsConstructor;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 链接：https://www.jianshu.com/p/f79fa5aafb44
 * 题目：三线程按顺序交替打印ABC的四种方法
 * 描述：建立三个线程A、B、C，A线程打印10次字母A，B线程打印10次字母B,C线程打印10次字母C，
 * 但是要求三个线程同时运行，并且实现交替打印，即按照ABCABCABC的顺序打印。
 */
public class ABC_Lock_Cond_Copy {

    private static int share = 0;
    private static Lock lock = new ReentrantLock();
    private static Condition conditionA = lock.newCondition();
    private static Condition conditionB = lock.newCondition();
    private static Condition conditionC = lock.newCondition();

    public static class a implements Runnable {
        @Override
        public void run() {
            int count = 10;
            while (count > 0) {
                lock.lock();
                try {
                    conditionA.signalAll();
                    System.out.println("ThreadA:A");
                    count--;

                    conditionC.await(1, TimeUnit.SECONDS);
                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static class b implements Runnable {
        @Override
        public void run() {
            int count = 10;
            while (count > 0) {
                lock.lock();
                try {
                    conditionB.signalAll();
                    System.out.println("ThreadB:B");
                    count--;

                    conditionA.await(1, TimeUnit.SECONDS);
                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static class c implements Runnable {
        @Override
        public void run() {
            int count = 10;
            while (count > 0) {
                lock.lock();
                try {
                    conditionC.signalAll();
                    System.out.println("ThreadC:C");
                    count--;

                    conditionB.await(1, TimeUnit.SECONDS);
                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new a()).start();
        new Thread(new b()).start();
        new Thread(new c()).start();

    }

}
